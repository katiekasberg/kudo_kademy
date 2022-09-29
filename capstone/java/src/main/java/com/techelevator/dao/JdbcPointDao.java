package com.techelevator.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcPointDao implements PointDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcPointDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //TODO: add null protection for below
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
    public int getPointsByClassId(int classId) {
        return 0;
    }
}