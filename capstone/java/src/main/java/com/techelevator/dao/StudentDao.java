package com.techelevator.dao;

import com.techelevator.model.exceptions.StudentProfileNotFoundException;
import com.techelevator.model.profile.Profile;
import com.techelevator.model.profile.StudentProfile;
import com.techelevator.model.school.ClassDetail;

import java.util.List;

public interface StudentDao {

    //get teacher email
    String getTeacherEmail(int classId);

    //get teacher profile
    Profile getTeacherProfile(int teacherId);

    List<StudentProfile> getAllStudentProfiles();

    StudentProfile getStudentProfileById(int studentId) throws StudentProfileNotFoundException;

    List<ClassDetail> getClassesAsStudent(int studentId);

}
