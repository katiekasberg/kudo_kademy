package com.techelevator.dao;

import com.techelevator.model.exceptions.ClassInfoNotFoundException;
import com.techelevator.model.exceptions.ProfileNotFoundException;
import com.techelevator.model.exceptions.StudentProfileNotFoundException;
import com.techelevator.model.profile.Profile;
import com.techelevator.model.profile.StudentProfile;
import com.techelevator.model.school.ClassDetail;
import com.techelevator.model.school.ClassInfo;
import com.techelevator.model.school.ClassInfoStudent;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTeacherDao implements TeacherDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcTeacherDao(JdbcTemplate jdbcTemplate) {
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

    //Possible edits: make school year auto fill to current school year, have teacher_id and school_id pulled in from Principal
    @Override
    public ClassInfo createNewClass(ClassInfo newClassInfo) {
        String sql = "INSERT INTO class_info (name, subject, teacher_id, school_id, description, period, start_time, end_time, school_year) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) " +
                "RETURNING id;";
        Integer newClassInfoId;
        try {
            newClassInfoId = jdbcTemplate.queryForObject(sql, Integer.class, newClassInfo.getName(), newClassInfo.getSubject(),
                    newClassInfo.getTeacherId(), newClassInfo.getSchoolId(), newClassInfo.getDescription(), newClassInfo.getPeriod(),
                    newClassInfo.getStartTime(), newClassInfo.getEndTime(), newClassInfo.getSchoolYear());
            newClassInfo.setId(newClassInfoId);
        } catch (DataAccessException e) {
            System.out.println("Database access exception");
        }
        return newClassInfo;
    }

    @Override
    public Profile getStaffProfileById(int staffId) throws ProfileNotFoundException {
        String sql = "SELECT id, first_name, last_name, email, image FROM profile WHERE profile.id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, staffId);

        if (results.next()) {
            return mapRowToProfile(results);
        }
        throw new ProfileNotFoundException();
    }

    @Override
    public List<StudentProfile> getStudentsInClass(int classId) {
        List<StudentProfile> studentsInClassList = new ArrayList<>();
        String sql =
                "SELECT profile.id, first_name, last_name, email, image, school_id, graduation_year " +
                        "FROM profile " +
                        "JOIN student ON profile.id = student.id " +
                        "JOIN class_info_student ON student.id = class_info_student.student_id " +
                        "WHERE class_id = ? " +
                        "ORDER BY first_name ASC;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, classId);

        while (results.next()) {
            studentsInClassList.add(mapRowToStudentProfile(results));
        }
        return studentsInClassList;
    }

    @Override
    public ClassDetail getClassDetailsByClassId(int classId) throws ClassInfoNotFoundException {
        String sql =
                "SELECT class_info.id, name, subject, class_info.teacher_id, first_name, last_name, email, school_id, description, period, start_time, end_time, school_year " +
                        "FROM class_info " +
                        "JOIN profile ON class_info.teacher_id = profile.id " +
                        "WHERE class_info.id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, classId);

        if (results.next()) {
            return (mapRowToClassDetail(results));
        }
        throw new ClassInfoNotFoundException();
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

    private Profile mapRowToProfile(SqlRowSet rs) {
        Profile profile = new Profile();
        profile.setId(rs.getInt("id"));
        profile.setFirstName(rs.getString("first_name"));
        profile.setLastName(rs.getString("last_name"));
        profile.setEmail(rs.getString("email"));
        profile.setImage(rs.getString("image"));
        return profile;
    }

    private StudentProfile mapRowToStudentProfile(SqlRowSet rs) {
        StudentProfile studentProfile = new StudentProfile();
        studentProfile.setId(rs.getInt("id"));
        studentProfile.setFirstName(rs.getString("first_name"));
        studentProfile.setLastName(rs.getString("last_name"));
        studentProfile.setEmail(rs.getString("email"));
        studentProfile.setImage(rs.getString("image"));
        studentProfile.setSchoolId(rs.getInt("school_id"));
        studentProfile.setGraduationYear(rs.getInt("graduation_year"));
        return studentProfile;
    }

    private ClassDetail mapRowToClassDetail(SqlRowSet rs){
        ClassDetail classDetail = new ClassDetail();
        classDetail.setId(rs.getInt("id"));
        classDetail.setName(rs.getString("name"));
        classDetail.setSubject(rs.getString("subject"));
        classDetail.setTeacherId(rs.getInt("teacher_id"));
        classDetail.setFirstName(rs.getString("first_name"));
        classDetail.setLastName(rs.getString("last_name"));
        classDetail.setEmail(rs.getString("email"));
        classDetail.setSchoolId(rs.getInt("school_id"));
        classDetail.setDescription(rs.getString("description"));
        classDetail.setPeriod(rs.getString("period"));
        classDetail.setStartTime(rs.getTime("start_time"));
        classDetail.setEndTime(rs.getTime("end_time"));
        classDetail.setSchoolYear(rs.getInt("school_year"));
        return classDetail;
    }
}