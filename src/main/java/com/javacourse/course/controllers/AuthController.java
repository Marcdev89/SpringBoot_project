package com.javacourse.course.controllers;
import com.javacourse.course.models.User;
import com.javacourse.course.repository.IUser;
import com.javacourse.course.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
    @Autowired
    private IUser iUser;
    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value= "api/login", method = RequestMethod.POST)
    public String login(@RequestBody User user){

        User logedUser = iUser.getUserByCredentials(user);
       if (logedUser != null){

          String tokenJWT = jwtUtil.create(String.valueOf(logedUser.getId()),logedUser.getEmail());
          return tokenJWT;
       }
           return "FAIL";
    }
}
