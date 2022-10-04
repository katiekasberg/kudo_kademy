package com.techelevator.dao;

import com.techelevator.model.exceptions.ParentNotFoundException;
import com.techelevator.model.profile.Parent;
import com.techelevator.model.profile.StudentProfile;

import java.util.List;

public interface ParentDao {

    //TODO: assign student to parent
    //parent can associate themselves to their child
    void addStudentToParent(int parentID, int studentId);

    //parent can get a list of their own children
    List<StudentProfile> myStudent(int parentId);

    //get Parent Profile By Id
    Parent getParentById(int parentId) throws ParentNotFoundException;
}
