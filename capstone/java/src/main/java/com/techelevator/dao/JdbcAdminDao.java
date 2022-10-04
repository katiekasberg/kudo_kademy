package com.techelevator.dao;

import com.techelevator.model.exceptions.AnnouncementNotFoundException;
import com.techelevator.model.school.Announcement;
import com.techelevator.model.school.NewAnnouncement;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcAdminDao implements AdminDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcAdminDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Announcement getLatestAnnouncement() {
        String sql = "SELECT announcement.id, school_id, message, profile.first_name, profile.last_name, time_stamp " +
                "FROM announcement " +
                "JOIN profile on profile.id = announcement.admin_id " +
                "ORDER BY id desc " +
                "LIMIT 1; ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        if(results.next()){
            return mapToAnnouncement(results);
        }

        return null;
    }

    @Override
    public Announcement getAnnouncementById(int announcementId) throws AnnouncementNotFoundException {
        String sql = "SELECT announcement.id, school_id, message, profile.first_name, profile.last_name, time_stamp " +
                "FROM announcement " +
                "JOIN profile on profile.id = announcement.admin_id " +
                "WHERE announcement.id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, announcementId);

        if(results.next()){
            return mapToAnnouncement(results);
        }

        throw new AnnouncementNotFoundException();
    }

    @Override
    public Announcement createAnnouncement(NewAnnouncement newAnnouncement, int adminId) {
        String sql = "INSERT INTO announcement (message, admin_id) " +
                     "VALUES (?,?) " +
                     "RETURNING id; ";
        Integer newAnnouncementId = 0;
        try {
            newAnnouncementId = jdbcTemplate.queryForObject(sql, Integer.class, newAnnouncement.getMessage(), adminId);
        } catch (DataAccessException e){
            System.out.println("Database access exception");
        }
        return getAnnouncementById(newAnnouncementId);
    }

    private Announcement mapToAnnouncement(SqlRowSet rs) {
        Announcement announcement = new Announcement();
        announcement.setId(rs.getInt("id"));
        announcement.setSchoolId(rs.getInt("school_id"));
        announcement.setMessage(rs.getString("message"));
        announcement.setFirstName(rs.getString("first_name"));
        announcement.setLastName(rs.getString("last_name"));
        announcement.setTimeStamp(rs.getTimestamp("time_stamp").toLocalDateTime());
        return announcement;
    }
}
