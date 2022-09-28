package com.techelevator.controller;

import com.techelevator.dao.TeacherDao;
import com.techelevator.model.school.ClassInfoStudent;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class TeacherController {

    private TeacherDao teacherDao;

    public TeacherController(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    //add student to a class
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/class-roster" , method= RequestMethod.POST)
    public void addStudentToClass(@RequestBody ClassInfoStudent classInfoStudent){
        teacherDao.addStudentToAClass(classInfoStudent);
    }

}
