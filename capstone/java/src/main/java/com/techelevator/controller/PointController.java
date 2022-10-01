package com.techelevator.controller;

import com.techelevator.dao.PointDao;
import com.techelevator.model.point.ClassPoint;
import com.techelevator.model.point.GradePoint;
import com.techelevator.model.point.StudentPoint;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class PointController {

    private PointDao pointDao;

    public PointController(PointDao pointDao) {
        this.pointDao = pointDao;
    }

    //get points by student id
    @RequestMapping(path = "/student-points/{studentId}", method= RequestMethod.GET)
    public int getPointsForStudent(@PathVariable int studentId){
        return pointDao.getPointsByStudentId(studentId);
    }

    //get points for all students
    @RequestMapping(path = "/student-points", method= RequestMethod.GET)
    public List<StudentPoint> listPointsForAllStudents(){
        return pointDao.getPointsForAllStudents();
    }

    //get points by grad date
    @RequestMapping(path = "/grade-points/{graduationYear}", method= RequestMethod.GET)
    public int getPointsForGrade(@PathVariable int graduationYear){
        return pointDao.getPointsByGraduationYear(graduationYear);
    }

    //get points for all grad years
    @RequestMapping(path = "/grade-points", method= RequestMethod.GET)
    public List<GradePoint> listPointsForAllGrades(){
        return pointDao.getPointsForAllGraduationYears();
    }

    //get points by class id
    @RequestMapping(path = "/class-points/{classId}", method= RequestMethod.GET)
    public int getPointsForClass(@PathVariable int classId){
        return pointDao.getPointsByClassId(classId);
    }

    //get points for all classes
    @RequestMapping(path = "/class-points", method= RequestMethod.GET)
    public List<ClassPoint> listPointsForAllClasses(){
        return pointDao.getPointsForAllClasses();
    }

}
