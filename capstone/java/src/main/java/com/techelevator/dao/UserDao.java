package com.techelevator.dao;

import com.techelevator.model.RegisterUserDTO;
import com.techelevator.model.User;
import com.techelevator.model.profile.Parent;
import com.techelevator.model.profile.Profile;
import com.techelevator.model.profile.StudentProfile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import java.util.List;

public interface UserDao {

    List<User> findAll();

    User getUserById(int userId);

    User findByUsername(String username);

    int findIdByUsername(String username);

    boolean create(String username, String password, String role);

    //changes below
    void createProfile(Profile newProfile);
    void createStudent(StudentProfile newStudentProfile);
    void createParent(Parent parent);
    //changes above
}
