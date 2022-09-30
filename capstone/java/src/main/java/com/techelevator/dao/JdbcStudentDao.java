package com.techelevator.dao;

import com.techelevator.model.exceptions.StudentProfileNotFoundException;
import com.techelevator.model.profile.Profile;
import com.techelevator.model.profile.StudentProfile;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcStudentDao implements StudentDao {

    private JdbcTemplate jdbcTemplate;
    public JdbcStudentDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String getTeacherEmail(int classId) {
        return null;
    }

    @Override
    public Profile getTeacherProfile(int teacherId) {
        return null;
    }

    @Override
    public List<StudentProfile> getAllStudentProfiles() {
        List<StudentProfile> studentProfiles = new ArrayList<>();
        String sql = "SELECT student.id, first_name, last_name, email, image, school_id, graduation_year " +
                "FROM profile " +
                "JOIN student ON profile.id = student.id;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            studentProfiles.add(mapRowToStudentProfile(results));
        }
        return studentProfiles;
    }

    @Override
    public StudentProfile getAllStudentProfileById(int studentId) throws StudentProfileNotFoundException {
        String sql = "SELECT student.id, first_name, last_name, email, image, school_id, graduation_year " +
                "FROM profile " +
                "JOIN student ON profile.id = student.id " +
                "WHERE student.id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, studentId);

        if (results.next()) {
            return mapRowToStudentProfile(results);
        }
        throw new StudentProfileNotFoundException();
    }


    private StudentProfile mapRowToStudentProfile(SqlRowSet rs){
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
}
