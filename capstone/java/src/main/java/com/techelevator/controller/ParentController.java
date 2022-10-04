package com.techelevator.controller;

import com.techelevator.dao.ParentDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.profile.Parent;
import com.techelevator.model.profile.StudentProfile;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class ParentController {

    private ParentDao parentDao;
    private UserDao userDao;

    public ParentController(ParentDao parentDao, UserDao userDao) {
        this.parentDao = parentDao;
        this.userDao = userDao;
    }

    //add student to a parent
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/parent/student" , method= RequestMethod.POST)
    public void addStudentToParent(Principal principal, int studentId){
        int userId = userDao.findIdByUsername(principal.getName());
        parentDao.addStudentToParent(userId,studentId);
    }
//    @ResponseStatus(HttpStatus.CREATED)
//    @RequestMapping(path = "/parent/{parentId}/student" , method= RequestMethod.POST)
//    public void addStudentToParent(@PathVariable int parentId, int studentId){
//        parentDao.addStudentToParent();
//    }

    //get a list of own children for parent
    @RequestMapping(path = "/parent/student" , method= RequestMethod.GET)
    public List<StudentProfile> listStudentForParent(Principal principal){
        int parentId = userDao.findIdByUsername(principal.getName());
        return parentDao.myStudent(parentId);
    }

    //get a parent profile by parent Id
    @RequestMapping(path = "/parent-profile/{parentId}", method = RequestMethod.GET)
    public Parent getParentProfileById(@PathVariable int parentId){
        return parentDao.getParentById(parentId);
    }


}