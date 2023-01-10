package com.techelevator.dao;

import com.techelevator.model.exceptions.ParentNotFoundException;
import com.techelevator.model.profile.Parent;
import com.techelevator.model.profile.ParentStudent;
import com.techelevator.model.profile.StudentProfile;

import java.util.List;

public interface ParentDao {

    //TODO: assign student to parent
    //parent can associate themselves to their child
    void addStudentToParent(ParentStudent student);

    //parent can get a list of their own children
    List<StudentProfile> myStudent(int parentId);

    //get Parent Profile By Id
    Parent getParentById(int parentId) throws ParentNotFoundException;

    //get a list of students not claimed by parent
    List<StudentProfile> listUnclaimedStudents(int parentId);


}
