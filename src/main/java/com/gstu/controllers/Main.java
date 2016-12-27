package com.gstu.controllers;

import com.gstu.dao.UserDao;
import com.gstu.executor.Executor;
import com.gstu.models.User;
import com.gstu.services.UserService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/railwaydb","root","5674");

        UserDao userDao = new UserDao(new Executor(connection));
        //System.out.println(userDao.findByLogin("shpetny.eugene@gmail.com"));

        List<User> users = new ArrayList<>();
        UserService userService = new UserService();
        users  = userService.getAllUsers();
        users = userDao.findAll();

        for (User user: users) {
            System.out.println(user);
        }

    }
}
