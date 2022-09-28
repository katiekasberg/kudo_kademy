package com.techelevator.dao;

import com.techelevator.model.kudo.Kudo;
import com.techelevator.model.kudo.KudoRequest;
import com.techelevator.model.school.ClassInfoStudent;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

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
}
