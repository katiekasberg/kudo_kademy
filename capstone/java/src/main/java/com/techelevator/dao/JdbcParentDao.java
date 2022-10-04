package com.techelevator.dao;

import com.techelevator.model.exceptions.ParentNotFoundException;
import com.techelevator.model.profile.Parent;
import com.techelevator.model.profile.Profile;
import com.techelevator.model.profile.StudentProfile;
import com.techelevator.model.school.ClassInfo;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class JdbcParentDao implements ParentDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcParentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;}

    @Override
    public void addStudentToParent(int parentId, int studentId) {
        String sql = "INSERT INTO parent_student (parent_id, student_id)" +
                "VALUES (?,?)";
        try {
            jdbcTemplate.update(sql, parentId, studentId);
        } catch (DataAccessException e) {
            System.out.println(" Database access exception");

        }
    }

    @Override
    public List<StudentProfile> myStudent(int parentId) {
        List<StudentProfile> parentStudent = new ArrayList<>();
        String sql =
                "SELECT id, first_name, last_name, email, image " +
                        "FROM profile " +
                        "JOIN parent_student on profile.id = parent_student.parent_id" +
                        "WHERE parent_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, parentId);

        while (results.next()) {
            parentStudent.add(mapRowToStudentProfile(results));
        }
        return parentStudent;
    }

    @Override
    public Parent getParentById(int parentId) throws ParentNotFoundException {
        String sql = "SELECT profile.id, first_name, last_name, email, image, phone_number, address " +
                     "FROM profile " +
                     "JOIN parent on parent.id = profile.id " +
                     "WHERE profile.id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, parentId);

        if(results.next()){
            return mapRowToParentProfile(results);
        }

        throw new ParentNotFoundException();
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

    private Parent mapRowToParentProfile(SqlRowSet rs){
        Parent parent = new Parent();
        parent.setId(rs.getInt("id"));
        parent.setFirstName(rs.getString("first_name"));
        parent.setLastName(rs.getString("last_name"));
        parent.setEmail(rs.getString("email"));
        parent.setImage(rs.getString("image"));
        parent.setPhoneNumber(rs.getString("phone_number"));
        parent.setAddress(rs.getString("address"));
        return parent;
    }

}

