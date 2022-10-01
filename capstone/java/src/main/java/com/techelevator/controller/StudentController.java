package com.techelevator.controller;

import com.techelevator.dao.StudentDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.profile.StudentProfile;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class StudentController {

    private StudentDao studentDao;
    private UserDao userDao;

    public StudentController(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    //get all student profiles
    @RequestMapping(path = "/student-profiles" , method= RequestMethod.GET)
    public List<StudentProfile> listAllStudentProfiles(){
        return studentDao.getAllStudentProfiles();
    }

    @RequestMapping(path = "/student-profiles/{studentId}" , method= RequestMethod.GET)
    public StudentProfile listAllStudentProfiles(@PathVariable int studentId){
        return studentDao.getAllStudentProfileById(studentId);
    }

}
