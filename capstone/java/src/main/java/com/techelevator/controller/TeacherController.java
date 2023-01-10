package com.techelevator.controller;

import com.techelevator.dao.TeacherDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.profile.Profile;
import com.techelevator.model.profile.StudentProfile;
import com.techelevator.model.school.ClassDetail;
import com.techelevator.model.school.ClassInfo;
import com.techelevator.model.school.ClassInfoStudent;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class TeacherController {

    private TeacherDao teacherDao;
    private UserDao userDao;

    public TeacherController(TeacherDao teacherDao, UserDao userDao) {
        this.teacherDao = teacherDao;
        this.userDao = userDao;
    }

    //see all students in a class
    @RequestMapping(path = "/class-roster/{classId}" , method= RequestMethod.GET)
    public List<StudentProfile> getAllStudentsInClass(@PathVariable int classId){
        return teacherDao.getStudentsInClass(classId);
    }

    //add student to a class
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/class-roster" , method= RequestMethod.POST)
    public void addStudentToClass(@RequestBody ClassInfoStudent classInfoStudent){
        teacherDao.addStudentToAClass(classInfoStudent);
    }

    //get a list of own classes as a teacher
    @RequestMapping(path = "/classes" , method= RequestMethod.GET)
    public List<ClassInfo> listClassesAsTeacher(Principal principal){
        int teacherId = userDao.findIdByUsername(principal.getName());
        return teacherDao.getClassesAsTeacher(teacherId);
    }

    //create a new class
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/classes" , method= RequestMethod.POST)
    public ClassInfo addNewClass(@RequestBody ClassInfo newClassInfo){
        return teacherDao.createNewClass(newClassInfo);
    }

    //get a staff profile based on staff Id
    @RequestMapping(path = "/staff-profiles/{staffId}" , method= RequestMethod.GET)
    public Profile getStaffProfileById(@PathVariable int staffId){
        return teacherDao.getStaffProfileById(staffId);
    }

    //get a list of classes by teacher id
    @RequestMapping(path = "/staff-profiles/{staffId}/classes" , method= RequestMethod.GET)
    public List<ClassInfo> getClassesByTeacherId(@PathVariable int staffId){
        return teacherDao.getClassesAsTeacher(staffId);
    }

    //get class details by a class ID
    @RequestMapping(path = "/classes/{classId}" , method= RequestMethod.GET)
    public ClassDetail getClassDetailsByClassId(@PathVariable int classId){
        return teacherDao.getClassDetailsByClassId(classId);
    }

}
