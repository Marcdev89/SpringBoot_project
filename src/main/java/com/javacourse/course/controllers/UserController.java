package com.javacourse.course.controllers;

import models.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @RequestMapping(value = "user")
    public User getUser(){
        User user = new User();
        user.setId(1L);
        user.setName("Lucas");
        user.setFirstname("Marx");
        user.setEmail("lucasmarx@gmail.com");
        user.setPhone("666999888");
        return user;
    }

    @RequestMapping(value = "user/{id}")
    public User getUser(@PathVariable Long id){
        User user = new User();
        user.setName("Lucas");
        user.setFirstname("Marx");
        user.setEmail("lucasmarx@gmail.com");
        user.setPhone("666999888");
        return user;
    }

    @RequestMapping(value = "user2")
    public User getUser2(){
        User user = new User();
        user.setName("Lucas");
        user.setFirstname("Marx");
        user.setEmail("lucasmarx@gmail.com");
        user.setPhone("666999888");
        return user;
    }


}
