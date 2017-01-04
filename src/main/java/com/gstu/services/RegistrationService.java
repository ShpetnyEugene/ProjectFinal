package com.gstu.services;

import com.gstu.dao.UserDao;
import com.gstu.executor.Executor;

public class RegistrationService {

    public boolean checkUserByLogin(String login) {
        UserDao userDao;
        userDao = new UserDao(new Executor(ConnectionFactory.getConnection()));
        return userDao.findByLogin(login) != null;
    }

    public boolean checkUserByIdentificationNumber(String identificationNumber) {
        UserDao userDao = new UserDao(new Executor(ConnectionFactory.getConnection()));
        return userDao.findByIdentificationNumber(identificationNumber) != null;
    }
}
