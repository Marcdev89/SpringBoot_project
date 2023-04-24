package com.javacourse.course.controllers;

import models.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @RequestMapping(value = "user")
    public User getUser1(){
        User user = new User();
        user.setId(1L);
        user.setName("Lucas");
        user.setSurname("Marx");
        user.setEmail("lucasmarx@gmail.com");
        user.setPhone("666999888");
        return user;
    }

    @RequestMapping(value = "user/{id}")
    public User getUser(@PathVariable Long id){
        User user = new User();
        user.setName("Lucas");
        user.setSurname("Marx");
        user.setEmail("lucasmarx@gmail.com");
        user.setPhone("666999888");
        return user;
    }

    @RequestMapping(value = "users")
    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setId(1L);
        user.setName("Lucas");
        user.setSurname("Marx");
        user.setEmail("lucasmarx@gmail.com");
        user.setPhone("666999888");
        users.add(user);

        User user2 = new User();
        user2.setId(2L);
        user2.setName("Andrew");
        user2.setSurname("Old");
        user2.setEmail("andrew@gmail.com");
        user2.setPhone("666555888");
        users.add(user2);

        User user3 = new User();
        user3.setId(3L);
        user3.setName("Joseph");
        user3.setSurname("Happy");
        user3.setEmail("bellyhappy@gmail.com");
        user3.setPhone("666777888");
        users.add(user3);

        return users;
    }


}
