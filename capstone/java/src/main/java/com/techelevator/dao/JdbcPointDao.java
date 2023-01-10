package com.techelevator.dao;

import com.techelevator.model.point.ClassPoint;
import com.techelevator.model.point.GradePoint;
import com.techelevator.model.point.StudentPoint;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPointDao implements PointDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcPointDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //TODO: add null protection for methods below
    //get points by student
    @Override
    public int getPointsByStudentId(int studentId) {
        String sql = "SELECT SUM(value) as total_points " +
                "FROM kudo_student " +
                "JOIN kudo_type ON kudo_student.type_id = kudo_type.id " +
                "WHERE student_id = ?;";
        int result = jdbcTemplate.queryForObject(sql, Integer.class, studentId);
        return result;
    }

    @Override
    public List<StudentPoint> getPointsForAllStudents() {
        List<StudentPoint> studentPointList = new ArrayList<>();
        String sql = "SELECT first_name || ' ' || last_name as full_name, SUM(value) as total_points  " +
                "FROM kudo_student " +
                "JOIN kudo_type ON kudo_student.type_id = kudo_type.id " +
                "JOIN profile ON kudo_student.student_id = profile.id " +
                "GROUP BY full_name " +
                "ORDER BY total_points DESC LIMIT 10;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            studentPointList.add(mapRowToStudentPoint(results));
        }
        return studentPointList;
    }

    @Override
    public int getPointsByGraduationYear(int graduationYear) {
        String sql = "SELECT SUM(value) as total_points " +
                "FROM kudo_student " +
                "JOIN kudo_type ON kudo_student.type_id = kudo_type.id " +
                "JOIN student ON kudo_student.student_id = student.id " +
                "WHERE graduation_year = ?;";
        int result = jdbcTemplate.queryForObject(sql, Integer.class, graduationYear);
        return result;
    }

    @Override
    public List<GradePoint> getPointsForAllGraduationYears() {
        List<GradePoint> gradePointList = new ArrayList<>();
        String sql = "SELECT graduation_year, SUM(value) as total_points " +
                "FROM kudo_student " +
                "JOIN kudo_type ON kudo_student.type_id = kudo_type.id " +
                "JOIN student ON kudo_student.student_id = student.id " +
                "GROUP BY graduation_year " +
                "ORDER BY total_points DESC;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            gradePointList.add(mapRowToGradePoint(results));
        }
        return gradePointList;
    }

    //TODO: do we want to limit this to points that were given out by the teacher of that class? Or by some other way? Currently, if a student is in more than 1 class they are "contributing" points to all their classes
    //^^Maybe we don't actually want to do this "by class" but instead need to add a separate mechanism for assigning students to groups?
    @Override
    public int getPointsByClassId(int classId) {
        String sql = "SELECT SUM(value) as total_points " +
                "FROM kudo_student " +
                "JOIN kudo_type ON kudo_student.type_id = kudo_type.id " +
                "JOIN class_info_student ON kudo_student.student_id = class_info_student.student_id " +
                "WHERE class_info_student.class_id = ?;";
        int result = jdbcTemplate.queryForObject(sql, Integer.class, classId);
        return result;
    }

    //TODO: see note above about class points
    @Override
    public List<ClassPoint> getPointsForAllClasses() {
        List<ClassPoint> classPointList = new ArrayList<>();
        String sql = "SELECT class_info.name || '- ' || class_info.period as class_name, SUM(value) as total_points " +
                "FROM kudo_student " +
                "JOIN kudo_type ON kudo_student.type_id = kudo_type.id " +
                "JOIN class_info_student ON kudo_student.student_id = class_info_student.student_id " +
                "JOIN class_info ON class_info_student.class_id = class_info.id " +
                "GROUP BY class_name " +
                "ORDER BY total_points DESC;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            classPointList.add(mapRowToClassPoint(results));
        }
        return classPointList;
    }

    private StudentPoint mapRowToStudentPoint(SqlRowSet rs) {
        StudentPoint studentPoint = new StudentPoint();
        studentPoint.setFullName(rs.getString("full_name"));
        studentPoint.setValue(rs.getInt("total_points"));
        return studentPoint;
    }

    private GradePoint mapRowToGradePoint(SqlRowSet rs) {
        GradePoint gradePoint = new GradePoint();
        gradePoint.setCurrentGradeLevel(gradePoint.currentGrade(rs.getInt("graduation_year")));
        gradePoint.setValue(rs.getInt("total_points"));
        return gradePoint;
    }

    private ClassPoint mapRowToClassPoint(SqlRowSet rs) {
        ClassPoint classPoint = new ClassPoint();
        classPoint.setClassName(rs.getString("class_name"));
        classPoint.setValue(rs.getInt("total_points"));
        return classPoint;
    }
}