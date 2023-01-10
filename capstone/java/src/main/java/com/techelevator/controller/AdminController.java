package com.techelevator.controller;

import com.techelevator.dao.AdminDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.profile.Profile;
import com.techelevator.model.school.Announcement;
import com.techelevator.model.school.ClassInfoStudent;
import com.techelevator.model.school.NewAnnouncement;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class AdminController {

    private AdminDao adminDao;
    private UserDao userDao;

    public AdminController(AdminDao adminDao, UserDao userDao){
        this.adminDao = adminDao;
        this.userDao = userDao;
    }

    //add an announcement
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/announcement" , method= RequestMethod.POST)
    public void addAnnouncement(@RequestBody NewAnnouncement newAnnouncement, Principal principal){
        int adminId = userDao.findIdByUsername(principal.getName());
        adminDao.createAnnouncement(newAnnouncement, adminId);
    }

    //get most recent announcement
    @RequestMapping(path = "/announcement" , method= RequestMethod.GET)
    public Announcement getLatestAnnouncement(){
        return adminDao.getLatestAnnouncement();
    }
}
