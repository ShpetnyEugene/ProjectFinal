package com.gstu.services;

import com.gstu.dao.UserDao;
import com.gstu.executor.Executor;
import com.gstu.models.User;

import java.sql.SQLException;

public class UserService {

    private final static Object lock = new Object();

    // Работает правильно
    public User getUserByLogin(String login) {
        UserDao userDao = null;

        try {
            userDao = new UserDao(new Executor(DataBaseConnection.getInstance().getConnection()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (userDao.findByLogin(login) != null){
            return userDao.findByLogin(login);
        }else {
            return null;
        }
    }
    
    // Работает правильно
    public boolean checkUserPassword(User user, String password) {
       if (user.getPassword().equals(password)){
           return true;
       }else{
           return false;
       }
    }

    public boolean addUser(User user) {
        synchronized (lock) {
         // do logic
        }
        return false;
    }
}