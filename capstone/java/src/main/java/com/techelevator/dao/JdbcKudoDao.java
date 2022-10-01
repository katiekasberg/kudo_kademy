package com.techelevator.dao;

import com.techelevator.model.exceptions.KudoNotFoundException;
import com.techelevator.model.exceptions.KudoTypeNotFoundException;
import com.techelevator.model.kudo.Kudo;
import com.techelevator.model.kudo.KudoDetail;
import com.techelevator.model.kudo.KudoRequest;
import com.techelevator.model.kudo.KudoType;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcKudoDao implements KudoDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcKudoDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Kudo getKudoById(int kudoId) throws KudoNotFoundException {
        Kudo kudo = null;
        String sql = "SELECT id, teacher_id, student_id, message, type_id, approval_status " +
                "FROM kudo_student " +
                "WHERE id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, kudoId);

        if (results.next()) {
            return mapRowToKudo(results);
        }
        throw new KudoNotFoundException();
    }

    @Override
    public List<KudoDetail> getStudentKudos(int studentId) {
        List<KudoDetail> kudos = new ArrayList<>();
        String sql = "SELECT kudo_student.id, teacher_id, profile.first_name, profile.last_name, student_id, message, kudo_student.type_id, kudo_type.name, kudo_type.description, kudo_type.value " +
                "FROM kudo_student " +
                "JOIN profile on profile.id = kudo_student.teacher_id " +
                "JOIN kudo_type on kudo_type.id = kudo_student.type_id " +
                "WHERE kudo_student.student_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, studentId);

        while (results.next()) {
            kudos.add(mapRowToKudoDetail(results));
        }
        return kudos;
    }

    @Override
    public List<Kudo> getClassKudos(int classId) {
        List<Kudo> kudos = new ArrayList<>();
        String sql =
                "SELECT kudo_student.id, kudo_student.teacher_id, kudo_student.student_id, kudo_student.message, kudo_student.type_id, kudo_student.approval_status " +
                        "FROM kudo_student " +
                        "JOIN class_info_student ON kudo_student.student_id = class_info_student.student_id " +
                        "WHERE class_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, classId);

        while (results.next()) {
            kudos.add(mapRowToKudo(results));
        }
        return kudos;
    }

    @Override
    public List<Kudo> getAllKudos() {
        List<Kudo> kudos = new ArrayList<>();
        String sql = "SELECT id, teacher_id, student_id, message, type_id, approval_status " +
                "FROM kudo_student ;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            kudos.add(mapRowToKudo(results));
        }
        return kudos;
    }

    @Override
    public List<KudoType> getTypesOfKudos() {
        List<KudoType> kudoTypes = new ArrayList<>();
        String sql = "SELECT id, name, description, value " +
                "FROM kudo_type;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            kudoTypes.add(mapRowToKudoType(results));
        }
        return kudoTypes;
    }

    //get a kudo type by kudo type id
    @Override
    public KudoType getKudoTypeById(int kudoTypeId) throws KudoTypeNotFoundException {
        KudoType kudoType = new KudoType();
        String sql = "SELECT id, name, description, value " +
                     "FROM kudo_type " +
                     "WHERE id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, kudoTypeId);

        if (results.next()) {
            return mapRowToKudoType(results);
        }
        throw new KudoTypeNotFoundException();
    }

    @Override
    public KudoType createKudoType(KudoType newKudoType) {
        String sql = "INSERT INTO kudo_type (name, description, value) " +
                "VALUES (?, ?, ?) " +
                "RETURNING id;";
        Integer newKudoTypeId;
        try {
            newKudoTypeId = jdbcTemplate.queryForObject(sql, Integer.class, newKudoType.getName(),
                    newKudoType.getDescription(), newKudoType.getValue());
            newKudoType.setId(newKudoTypeId);
        } catch (DataAccessException e) {
            System.out.println("Kudo database access exception");
        }
        return newKudoType;
    }

    @Override
    public KudoType updateKudoType(KudoType updatedKudoType, int kudoTypeId) {
        String sql = "UPDATE kudo_type SET name = ?, description = ?, value = ? WHERE id = ?;";
        try {
           jdbcTemplate.update(sql, updatedKudoType.getName(), updatedKudoType.getDescription(), updatedKudoType.getValue(), kudoTypeId);
           updatedKudoType.setId(kudoTypeId);
        } catch (DataAccessException e) {
            System.out.println("Kudo database access exception");
        }
        return updatedKudoType;
    }

//    @Override
//    public KudoType createKudoType(NewKudoType newKudoType) {
//        return null;
//    }

    @Override
    public Kudo submitKudo(int teacherId, KudoRequest newKudoRequest) {
        String sql = "INSERT INTO kudo_student (teacher_id, student_id, message, type_id) " +
                "VALUES (?, ?, ?, ?) " +
                "RETURNING id;";
        int kudoId = 0;
        try {
            kudoId = jdbcTemplate.queryForObject(sql, Integer.class, teacherId, newKudoRequest.getStudentId(),
                    newKudoRequest.getMessage(), newKudoRequest.getTypeId());
        } catch (DataAccessException e) {
            System.out.println(" Kudo database access exception");
        }

        return getKudoById(kudoId);
    }

    private Kudo mapRowToKudo(SqlRowSet rs) {
        Kudo kudo = new Kudo();
        kudo.setId(rs.getInt("id"));
        kudo.setTeacherId(rs.getInt("teacher_id"));
        kudo.setStudentId(rs.getInt("student_id"));
        kudo.setMessage(rs.getString("message"));
        kudo.setTypeId(rs.getInt("type_id"));
        kudo.setApprovalStatus(rs.getString("approval_status"));
        return kudo;
    }

    private KudoDetail mapRowToKudoDetail(SqlRowSet rs) {
        KudoDetail kudoDetail = new KudoDetail();
        kudoDetail.setId(rs.getInt("id"));
        kudoDetail.setTeacherId(rs.getInt("teacher_id"));
        kudoDetail.setFirstName(rs.getString("first_name"));
        kudoDetail.setLastName(rs.getString("last_name"));
        kudoDetail.setStudentId(rs.getInt("student_id"));
        kudoDetail.setMessage(rs.getString("message"));
        kudoDetail.setTypeId(rs.getInt("type_id"));
        kudoDetail.setKudoTypeName(rs.getString("name"));
        kudoDetail.setKudoTypeDescription(rs.getString("description"));
        kudoDetail.setKudoTypeValue(rs.getInt("value"));
        return kudoDetail;
    }



    private KudoType mapRowToKudoType(SqlRowSet rs) {
        KudoType kudoType = new KudoType();
        kudoType.setId(rs.getInt("id"));
        kudoType.setName(rs.getString("name"));
        kudoType.setDescription(rs.getString("description"));
        kudoType.setValue(rs.getInt("value"));
        return kudoType;
    }

}
