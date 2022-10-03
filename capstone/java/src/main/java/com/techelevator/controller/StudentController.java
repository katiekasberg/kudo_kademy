package com.techelevator.controller;

import com.techelevator.dao.StudentDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.profile.StudentProfile;
import com.techelevator.model.school.ClassDetail;
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

    //get a specific student's profile by student ID
    @RequestMapping(path = "/student-profiles/{studentId}" , method= RequestMethod.GET)
    public StudentProfile listAllStudentProfiles(@PathVariable int studentId){
        return studentDao.getAllStudentProfileById(studentId);
    }

    //get a list of classes based on student Id
    @RequestMapping(path = "/student-profiles/{studentId}/classes" , method= RequestMethod.GET)
    public List<ClassDetail> listStudentClasses(@PathVariable int studentId){
        return studentDao.getClassesAsStudent(studentId);
    }
}
