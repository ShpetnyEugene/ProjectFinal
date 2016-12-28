package com.gstu.controllers;

import com.gstu.dao.TrainDao;
import com.gstu.dao.UserDao;
import com.gstu.executor.Executor;
import com.gstu.services.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {

        Connection connection = ConnectionFactory.getConnection();

        UserDao userDao = new UserDao(new Executor(connection));
        //System.out.println(userDao.findByLogin("shpetny.eugene@gmail.com"));

        TrainDao trainDao = new TrainDao(new Executor((connection)));

        System.out.println(trainDao.findAll());

        trainDao.deleteById(1L);

        System.out.println(trainDao.findAll());


    }
}
