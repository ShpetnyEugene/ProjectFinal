package com.gstu.controllers;

import com.gstu.dao.UserDao;
import com.gstu.executor.Executor;
import com.gstu.services.DataBaseConnection;

import java.sql.Connection;
import java.sql.SQLException;


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
        Connection connection = DataBaseConnection.getInstance().getConnection();

        UserDao userDao = new UserDao(new Executor(connection));
        System.out.println(userDao.findByLogin("shpetny.eugene@gmail.com"));

    }

}
