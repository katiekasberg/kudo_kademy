package com.techelevator.dao;

import com.techelevator.model.school.ClassInfo;
import com.techelevator.model.school.ClassInfoStudent;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTeacherDao implements TeacherDao{

    private JdbcTemplate jdbcTemplate;
    public JdbcTeacherDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addStudentToAClass(ClassInfoStudent classInfoStudent) {
        String sql = "INSERT INTO class_info_student(class_id, student_id) VALUES(?, ?);";
        try {
            jdbcTemplate.update(sql, classInfoStudent.getClassId(), classInfoStudent.getStudentId());
        } catch (DataAccessException e) {
            System.out.println(" Database access exception");
        }
    }

    @Override
    public List<ClassInfo> getClassesAsTeacher(int teacherId) {
        List<ClassInfo> classes = new ArrayList<>();
        String sql =
                "SELECT id, name, subject, teacher_id, school_id, description, period, start_time, end_time, school_year " +
                        "FROM class_info " +
                        "WHERE teacher_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, teacherId);

        while (results.next()) {
            classes.add(mapRowToClassInfo(results));
        }
        return classes;
    }

    private ClassInfo mapRowToClassInfo(SqlRowSet rs) {
        ClassInfo classInfo = new ClassInfo();
        classInfo.setId(rs.getInt("id"));
        classInfo.setName(rs.getString("name"));
        classInfo.setSubject(rs.getString("subject"));
        classInfo.setTeacherId(rs.getInt("teacher_id"));
        classInfo.setSchoolId(rs.getInt("school_id"));
        classInfo.setDescription(rs.getString("description"));
        classInfo.setPeriod(rs.getString("period"));
        classInfo.setStartTime(rs.getTime("start_time"));
        classInfo.setEndTime(rs.getTime("end_time"));
        classInfo.setSchoolYear(rs.getInt("school_year"));
        return classInfo;
    }
}