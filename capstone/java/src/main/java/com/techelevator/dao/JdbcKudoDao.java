package com.techelevator.dao;

import com.techelevator.model.exceptions.KudoNotFoundException;
import com.techelevator.model.kudo.Kudo;
import com.techelevator.model.kudo.KudoRequest;
import com.techelevator.model.kudo.KudoType;
import com.techelevator.model.kudo.NewKudoType;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcKudoDao implements KudoDao{

    private JdbcTemplate jdbcTemplate;
    public JdbcKudoDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Kudo getKudoById(int kudoId) throws KudoNotFoundException {
        Kudo kudo = null;
        String sql = "SELECT id, teacher_id, student_id, message, type_id, approval_status " +
                     "FROM kudo_student " +
                     "WHERE id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, kudoId);

        if(results.next()){
            return mapRowToKudo(results);
        }
        throw new KudoNotFoundException();
    }

    @Override
    public List<Kudo> getStudentKudos(int studentId) {
        List<Kudo> kudos = new ArrayList<>();
        String sql = "SELECT id, teacher_id, student_id, message, type_id, approval_status " +
                     "FROM kudo_student " +
                     "WHERE student_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, studentId);

        while(results.next()){
            kudos.add(mapRowToKudo(results));
        }
        return kudos;
    }

    @Override
    public List<Kudo> getClassKudos(int classId) {
        return null;
    }

    @Override
    public List<KudoType> getTypesOfKudos() {
        return null;
    }

    @Override
    public KudoType createKudoType(NewKudoType newKudoType) {
        return null;
    }

    @Override
    public Kudo submitKudo(int teacherId, KudoRequest newKudoRequest) {
        String sql = "INSERT INTO kudo_student (teacher_id, student_id, message, type_id) " +
                     "VALUES (?, ?, ?, ?) " +
                     "RETURNING id;";
        int kudoId = 0;
        try{
            kudoId = jdbcTemplate.queryForObject(sql, Integer.class, teacherId, newKudoRequest.getStudentId(),
                                                 newKudoRequest.getMessage(), newKudoRequest.getTypeId());
        } catch (DataAccessException e){
            System.out.println(" Kudo database access exception");
        }

        return getKudoById(kudoId);
    }

    private Kudo mapRowToKudo(SqlRowSet rs){
        Kudo kudo = new Kudo();
        kudo.setId(rs.getInt("id"));
        kudo.setTeacherId(rs.getInt("teacher_id"));
        kudo.setStudentId(rs.getInt("student_id"));
        kudo.setMessage(rs.getString("message"));
        kudo.setTypeId(rs.getInt("type_id"));
        kudo.setApprovalStatus(rs.getString("approval_status"));
        return kudo;
    }


}
