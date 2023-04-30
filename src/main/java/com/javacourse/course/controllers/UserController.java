package com.javacourse.course.controllers;
import com.javacourse.course.models.User;
import com.javacourse.course.repository.IUser;
import com.javacourse.course.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private IUser iUser;
    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/users", method = RequestMethod.GET)
    public List<User> getUsers(@RequestHeader(value="Authorization") String token){
        if (!isTokenValidated(token)) {
            return null;}
        return iUser.getUsers();
    }
    private boolean isTokenValidated(String token){
        String userId = jwtUtil.getKey(token);
        return userId != null;
    }

    @RequestMapping(value = "api/users", method = RequestMethod.POST)
    public void createNewUser(@RequestBody User user){

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1,1024,1, user.getPassword());
        user.setPassword(hash);

        iUser.register(user);
    }

    @RequestMapping(value = "api/users/{id}", method = RequestMethod.DELETE)
    public void delete(@RequestHeader(value = "Authorization") String token, @PathVariable Long id) {
        if (!isTokenValidated(token)){
            return;
        }
        iUser.delete(id);
    }




}
