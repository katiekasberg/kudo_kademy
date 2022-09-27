package com.techelevator.controller;

import com.techelevator.dao.KudoDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.kudo.Kudo;
import com.techelevator.model.kudo.KudoRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class KudoController {

    private KudoDao kudoDao;
    private UserDao userDao;

    public KudoController(KudoDao kudoDao, UserDao userDao) {
        this.kudoDao = kudoDao;
        this.userDao = userDao;
    }

    //get a kudo by id
    @RequestMapping(path = "/kudos/{id}", method= RequestMethod.GET)
    public Kudo getKudoById(@PathVariable int id){
        return kudoDao.getKudoById(id);
    }

    //get all kudos related user's student id
    @RequestMapping(path = "/kudos" , method= RequestMethod.GET)
    public List<Kudo> listUserKudos(Principal principal){
        int userId = userDao.findIdByUsername(principal.getName());
        return kudoDao.getStudentKudos(userId);
    }


    //send kudos to a student
    @RequestMapping(path = "/kudos" , method= RequestMethod.POST)
    public Kudo sendKudos(Principal principal, @RequestBody KudoRequest kudoRequest){
        int userId = userDao.findIdByUsername(principal.getName());
        return kudoDao.submitKudo(userId, kudoRequest);
    }

}
