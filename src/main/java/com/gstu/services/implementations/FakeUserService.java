package com.gstu.services.implementations;

import com.gstu.models.Role;
import com.gstu.models.User;
import com.gstu.services.UserService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * This class for debugging and testing. I use it for developing without database.
 */
public class FakeUserService implements UserService{

    private List<User> users = new ArrayList<>();

    {
        users.add(new User("User", "Useravich", "Userov", new Date(2344), "HB", "user", "user", Role.ADMIN));
    }

    @Override
    public User getUserByLogin(String login) {
        return users.get(0);
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public void deleteUserById(Long id) {
        //
    }

    @Override
    public boolean addUser(User user) {
        return true;
    }

    @Override
    public boolean checkUserPassword(User user, String password) {
        return true;
    }
}
