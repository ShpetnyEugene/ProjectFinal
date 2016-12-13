package com.gstu.services;

import com.gstu.dao.UserDao;
import com.gstu.models.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {

    private static Map<String, User> users = new HashMap<>();

    public User getUserByEmail(String email) {
        User user = null;
        return UserService.users.get(email);
    }

    public boolean checkUserPassword(String email, String password) {
        UserDao userDao = new UserDao();

        boolean bo = false;

        List<User> users = userDao.findAll();
        //User user = UserService.users.get(email);

        for (int i = 0; i < users.size(); i++){
            if (users.get(i).getLogin() == email && users.get(i).getPassword() == password){
                return users.get(i).equals(password);
            }
        }


/*
        if (user != null) {
            return user.getPassword().equals(password);
        } else {
            return false;
        }
*/

        return bo;
    }

    public synchronized boolean addUser(User user) {

        return false;
    }
}
