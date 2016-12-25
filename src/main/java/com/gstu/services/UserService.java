package com.gstu.services;

import com.gstu.dao.UserDao;
import com.gstu.executor.Executor;
import com.gstu.models.User;

import java.sql.SQLException;

public class UserService {

    private final static Object lock = new Object();

    private final UserDao userDao;

    public UserService() throws SQLException {
        this.userDao = new UserDao(new Executor(DataBaseConnection.getInstance().getConnection()));
    }

    public User getUserByLogin(String login) {
        return userDao.findByLogin(login);
    }

    // Работает правильно
    public boolean checkUserPassword(User user, String password) {
        return user.getPassword().equals(password);
    }

    public boolean addUser(User user) {
        synchronized (lock) {
            // TODO check in login don't repeat

            userDao.insertUser(user);
        }
        return false;
    }
}