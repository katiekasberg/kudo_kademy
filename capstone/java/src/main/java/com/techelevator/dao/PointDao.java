package com.techelevator.dao;

public interface PointDao {

    //get points by student
    int getPointsByStudentId(int studentId);

    //get points by grade
   int getPointsByGraduationYear(int graduationYear);

    //get points by class
    int getPointsByClassId(int classId);

}
