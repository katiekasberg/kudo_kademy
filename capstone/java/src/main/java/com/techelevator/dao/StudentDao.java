package com.techelevator.dao;

import com.techelevator.model.kudo.Kudo;
import com.techelevator.model.profile.Profile;

import java.util.List;

public interface StudentDao {

    //get teacher email
    String getTeacherEmail(int classId);

    //get teacher profile
    Profile getTeacherProfile(int teacherId);

    List<Profile> getAllStudents();

}
