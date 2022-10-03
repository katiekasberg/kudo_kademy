package com.techelevator.controller;

import com.techelevator.dao.KudoDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.kudo.Kudo;
import com.techelevator.model.kudo.KudoDetail;
import com.techelevator.model.kudo.KudoRequest;
import com.techelevator.model.kudo.KudoType;
import org.springframework.http.HttpStatus;
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

    //get all kudos related for a user's student id
    @RequestMapping(path = "/kudos" , method= RequestMethod.GET)
    public List<KudoDetail> listUserKudos(Principal principal){
        int userId = userDao.findIdByUsername(principal.getName());
        return kudoDao.getStudentKudos(userId);
    }

    //TODO: edit endpoint paths
    //get all kudos for a class id
    @RequestMapping(path = "/class-kudos/{classId}" , method= RequestMethod.GET)
    public List<Kudo> listClassKudos(@PathVariable int classId){
        return kudoDao.getClassKudos(classId);
    }

    //get all kudos for all students
    @RequestMapping(path = "/student-kudos" , method= RequestMethod.GET)
    public List<Kudo> listAllKudos(){
        return kudoDao.getAllKudos();
    }

    //get all kudos assign to studentId
    @RequestMapping(path = "/student-kudos/{studentId}" , method= RequestMethod.GET)
    public List<KudoDetail> listAllKudos(@PathVariable int studentId){
        return kudoDao.getStudentKudos(studentId);
    }

    //get all kudos of students graduating a certain year
    @RequestMapping(path = "/kudos/gradyear/{graduationYear}" , method= RequestMethod.GET)
    public List<KudoDetail> listKudosByGradYear(@PathVariable int graduationYear){
        return kudoDao.getKudosByGraduationYear(graduationYear);
    }



    //get list of kudo types
    @RequestMapping(path = "/kudo-types" , method= RequestMethod.GET)
    public List<KudoType> listKudoTypes(){
        return kudoDao.getTypesOfKudos();
    }

    //get kudo-type by kudoTypeId
    @RequestMapping(path= "/kudo-types/{kudoTypeId}" , method = RequestMethod.GET)
    public KudoType getKudoTypeById(@PathVariable int kudoTypeId){
        return kudoDao.getKudoTypeById(kudoTypeId);
    }


    //create new kudo type
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/kudo-types" , method= RequestMethod.POST)
    public KudoType createNewKudoType(@RequestBody KudoType newKudoType){
        return kudoDao.createKudoType(newKudoType);
    }

    //edit a kudo type
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(path = "/kudo-types/{kudoTypeId}" , method= RequestMethod.PUT)
    public KudoType editKudoType(@RequestBody KudoType updatedKudoType, @PathVariable int kudoTypeId){
        return kudoDao.updateKudoType(updatedKudoType, kudoTypeId);
    }

    //send kudos to a student
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_TEACHER')")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/kudos" , method= RequestMethod.POST)
    public Kudo sendKudos(Principal principal, @RequestBody KudoRequest kudoRequest){
        int userId = userDao.findIdByUsername(principal.getName());
        return kudoDao.submitKudo(userId, kudoRequest);
    }

}
