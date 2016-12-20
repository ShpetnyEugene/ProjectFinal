package com.gstu.controllers;

import com.gstu.dao.UserDao;
import com.gstu.executor.Executor;

import java.sql.*;


public class Main {
    public static void main(String[] args) throws SQLException {
        /*UserDao userDao = new UserDao();
        List<User> users = new ArrayList<>();

        users = userDao.findAll();

        String login = "shpetny.eugene@gmail.com";
        String password = "123";

        for (User ue: users) {
            System.out.println(ue);
        }


        User us = null;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getLogin().equals(login) && users.get(i).getPassword().equals(password)){
                us = users.get(i);
            }
        }
        System.out.println(us);

        UserService service = new UserService();

        System.out.println(service.checkUserPassword("shpetny.eugene@gmail.com","123"));
        System.out.println(service.getUserByEmail("mike@mail.ru"));
*/
//        Connection connection = DataBaseConnection.getInstance().getConnection();
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/railwaydb","root","5674");

        UserDao userDao = new UserDao(new Executor(connection));
        System.out.println(userDao.findByLogin("shpetny.eugene@gmail.com"));


        PreparedStatement statement = connection.prepareStatement("INSERT INTO train (name,numberFreePlaces) VALUES(?,?)");

        statement.setString(1, new String("KS 323"));
        statement.setInt(2, 20);

        statement.executeUpdate();
        statement.close();
        connection.close();
    }
}
