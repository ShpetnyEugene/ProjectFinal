package com.gstu.controllers;

import com.gstu.dao.UserDao;
import com.gstu.executor.Executor;
import com.gstu.models.User;
import com.gstu.services.DataBaseConnection;
import com.gstu.utils.ViewUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String patronymic = req.getParameter("patronymic");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String passportSerial = req.getParameter("passportSerial");

        try {
            UserDao userDao = new UserDao(new Executor(DataBaseConnection.getInstance().getConnection()));
            userDao.insertUser(new User(firstName,lastName,patronymic,20,passportSerial,login,password,2));

        } catch (SQLException e) {
            e.printStackTrace();
        }





        req.getRequestDispatcher("/WEB-INF/views/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ViewUtils.doView("registration", response, request);
    }
}