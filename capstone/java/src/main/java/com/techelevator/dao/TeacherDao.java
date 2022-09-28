package com.techelevator.dao;

import com.techelevator.model.school.ClassInfoStudent;

public interface TeacherDao {

    //teacher can associate students with a class
    void addStudentToAClass(ClassInfoStudent classInfoStudent);



    //TODO: add all my students (what does this mean?)
    //get a list of all teachers
    //search by name, class, grade, group, etc... to return a single student or list of students
    //add positive behavior comments and rewards
    //give house points for positive behaviors
    //get the current house points
    //create reports
    //add disciplinary actions/behavior warning (OPTIONAL)
    //set my notification setting (OPTIONAL)
}
