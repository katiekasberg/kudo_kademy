package com.techelevator.dao;

import com.techelevator.model.exceptions.ClassInfoNotFoundException;
import com.techelevator.model.profile.Profile;
import com.techelevator.model.profile.StudentProfile;
import com.techelevator.model.school.ClassDetail;
import com.techelevator.model.school.ClassInfo;
import com.techelevator.model.school.ClassInfoStudent;

import java.util.List;

public interface TeacherDao {

    //teacher can associate students with a class
    void addStudentToAClass(ClassInfoStudent classInfoStudent);

    //teacher can get a list of their own classes
    List<ClassInfo> getClassesAsTeacher(int teacherId);

    //teacher can create a class
    ClassInfo createNewClass(ClassInfo newClassInfo);

    //get a staff's profile by id
    Profile getStaffProfileById(int staffId);

    List<StudentProfile> getStudentsInClass(int classId);

    ClassDetail getClassDetailsByClassId(int classId) throws ClassInfoNotFoundException;

}
