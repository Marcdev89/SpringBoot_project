package com.javacourse.course.controllers;
import com.javacourse.course.models.User;
import com.javacourse.course.repository.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
    @Autowired
    private IUser iUser;

    @RequestMapping(value= "api/login", method = RequestMethod.POST)
    public String login(@RequestBody User user){
       if (iUser.verifyEmailPassword(user)){
           return "OK";
       }
           return "FAIL";

    }
}
