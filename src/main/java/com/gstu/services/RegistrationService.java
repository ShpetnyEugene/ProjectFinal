package com.gstu.services;

import com.gstu.dao.UserDao;
import com.gstu.executor.Executor;

import java.sql.SQLException;

public class RegistrationService {

    public boolean checkUserByLogin(String login) {
        UserDao userDao = null;

        try {
            userDao = new UserDao(new Executor(DataBaseConnection.getInstance().getConnection()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userDao.findByLogin(login) != null;
    }

    public boolean checkUserByPassportSerial (String passportSerial){
        UserDao userDao = null;

        try {
            userDao = new UserDao(new Executor(DataBaseConnection.getInstance().getConnection()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (userDao.findByPassportSerial(passportSerial) != null){
            return true;
        }else {
            return false;
        }
    }


}
