package com.techelevator.dao;

import com.techelevator.model.profile.Profile;
import com.techelevator.model.profile.StudentProfile;

import java.util.List;

public interface StudentDao {

    //get teacher email
    String getTeacherEmail(int classId);

    //get teacher profile
    Profile getTeacherProfile(int teacherId);

    List<StudentProfile> getAllStudentProfiles();

}
