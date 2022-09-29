package com.techelevator.dao;

import com.techelevator.model.point.ClassPoint;
import com.techelevator.model.point.GradePoint;
import com.techelevator.model.point.StudentPoint;

import java.util.List;

public interface PointDao {

    //get points by student
    int getPointsByStudentId(int studentId);

    //get list of students with points
    List<StudentPoint> getPointsForAllStudents();

    //get points by grade
   int getPointsByGraduationYear(int graduationYear);

   //get list of grades with points
    List<GradePoint> getPointsForAllGraduationYears();

    //get points by class
    int getPointsByClassId(int classId);

    //get list of classes with points
    List<ClassPoint> getPointsForAllClasses();

}
