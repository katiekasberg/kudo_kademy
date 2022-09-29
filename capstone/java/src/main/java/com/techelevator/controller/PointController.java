package com.techelevator.controller;

import com.techelevator.dao.PointDao;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    //get points by grad date
    @RequestMapping(path = "/grade-points/{graduationYear}", method= RequestMethod.GET)
    public int getPointsForGrade(@PathVariable int graduationYear){
        return pointDao.getPointsByGraduationYear(graduationYear);
    }

    //get points by class id
    @RequestMapping(path = "/class-points/{classId}", method= RequestMethod.GET)
    public int getPointsForClass(@PathVariable int classId){
        return 0;
    }

}
