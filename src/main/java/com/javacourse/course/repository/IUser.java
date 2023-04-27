package com.javacourse.course.repository;
import com.javacourse.course.models.User;

import java.util.List;

public interface IUser {

    List<User> getUsers();

    void delete(Long id);

    void register(User user);

   boolean verifyEmailPassword(User user);
}
