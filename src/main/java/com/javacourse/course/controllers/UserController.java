package com.javacourse.course.controllers;

import com.javacourse.course.models.User;
import com.javacourse.course.repository.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private IUser iUser;

    @RequestMapping(value = "api/user")
    public User getUser1(){
        User user = new User();
        user.setId(1L);
        user.setName("Lucas");
        user.setSurname("Marx");
        user.setEmail("lucasmarx@gmail.com");
        user.setPhone("666999888");
        return user;
    }

    @RequestMapping(value = "api/users/{id}")
    public User getUser(@PathVariable Long id){
        User user = new User();
        user.setName("Lucas");
        user.setSurname("Marx");
        user.setEmail("lucasmarx@gmail.com");
        user.setPhone("666999888");
        return user;
    }

    @RequestMapping(value = "api/users")
    public List<User> getUsers(){
        return iUser.getUsers();
    }
    @RequestMapping(value = "api/users/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        iUser.delete(id);
    }


}
