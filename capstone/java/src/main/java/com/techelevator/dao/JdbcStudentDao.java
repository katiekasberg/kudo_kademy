package com.techelevator.dao;

import com.techelevator.model.profile.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcStudentDao implements StudentDao{
    @Override
    public String getTeacherEmail(int classId) {
        return null;
    }

    @Override
    public Profile getTeacherProfile(int teacherId) {
        return null;
    }

    @Override
    public List<Profile> getAllStudents() {
        return null;
    }
}
