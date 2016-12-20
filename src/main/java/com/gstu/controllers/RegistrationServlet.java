package com.gstu.controllers;

import com.gstu.dao.UserDao;
import com.gstu.executor.Executor;
import com.gstu.models.User;
import com.gstu.services.DataBaseConnection;
import com.gstu.services.RegistrationService;
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

    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String PATRONYMIC = "patronymic";
    private static final String PASSPORT_SERIAL = "passportSerial";


    private RegistrationService registrationService = new RegistrationService();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter(FIRST_NAME);
        String lastName = req.getParameter(LAST_NAME);
        String patronymic = req.getParameter(PATRONYMIC);
        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);
        String passportSerial = req.getParameter(PASSPORT_SERIAL);


        if (registrationService.checkUserByLogin(login) || registrationService.checkUserByPassportSerial(passportSerial)) {
            resp.sendRedirect("/registration");
        } else {
            resp.sendRedirect("/login");
            try {
                UserDao userDao = new UserDao(new Executor(DataBaseConnection.getInstance().getConnection()));
                userDao.insertUser(new User(firstName, lastName, patronymic, 20, passportSerial, login, password, 2));

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ViewUtils.doView("registration", response, request);
    }
}