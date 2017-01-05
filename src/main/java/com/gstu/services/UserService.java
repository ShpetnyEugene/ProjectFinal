package com.gstu.services;

import com.gstu.models.User;

import java.util.List;

public interface UserService {

    User getUserByLogin(String login);
    List<User> getAllUsers();
    void deleteUserById(Long id);
    boolean addUser(User user);
    boolean checkUserPassword(User user, String password);
}
