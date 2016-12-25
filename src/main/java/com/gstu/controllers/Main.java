package com.gstu.controllers;

import com.gstu.dao.UserDao;
import com.gstu.executor.Executor;

import java.sql.*;


public class Main {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/railwaydb","root","5674");

        UserDao userDao = new UserDao(new Executor(connection));
        System.out.println(userDao.findByLogin("shpetny.eugene@gmail.com"));


        PreparedStatement statement = connection.prepareStatement("INSERT INTO train (name,numberFreePlaces) VALUES(?,?)");

        statement.setString(1, "KS 323");
        statement.setInt(2, 20);

        statement.executeUpdate();
        statement.close();
        connection.close();
    }
}
