package com.gstu.controllers;

import com.gstu.models.Role;
import com.gstu.models.User;
import com.gstu.services.RegistrationService;
import com.gstu.services.UserService;
import com.gstu.utils.ViewUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String PATRONYMIC = "patronymic";
    private static final String IDENTIFICATION_NUMBER = "identificationNumber";
    private static final String BIRTHDAY = "birthDay";

    private RegistrationService registrationService = new RegistrationService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter(FIRST_NAME);
        String lastName = req.getParameter(LAST_NAME);
        String patronymic = req.getParameter(PATRONYMIC);
        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);
        String identificationNumber = req.getParameter(IDENTIFICATION_NUMBER);
        String birthDay = req.getParameter(BIRTHDAY);


        System.out.println(birthDay);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy");

        System.out.println(birthDay);

        java.util.Date date = null;

        try {
             date = dateFormat.parse(birthDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("EXECUTOR : " + date);



        Date birthdayDate = Date.valueOf(dateFormat1.format(date));

        String errorMessages = "";
        if(StringUtils.isBlank(lastName)) {
            errorMessages += "last name is empty ";
        }

        if ( StringUtils.isNotBlank(errorMessages)
                || registrationService.checkUserByLogin(login)
                        || registrationService.checkUserByIdentificationNumber(identificationNumber)) {

            req.setAttribute("error", errorMessages);

            ViewUtils.doView("registration", resp, req);
        } else {
            resp.sendRedirect("/login");

            try {
                UserService userService = new UserService();
                userService.addUser(new User(firstName, lastName, patronymic, birthdayDate, identificationNumber, login, password, Role.USER));
                // userService.addUser(new User(firstName, lastName, patronymic, 20, identificationNumber, login, password, Role.USER));

            } catch (SQLException e) {
                e.printStackTrace();
            }


            /*try {
                // Replace by service call
                UserDao userDao = new UserDao(new Executor(DataBaseConnection.getInstance().getConnection()));
                userDao.insertUser(new User(firstName, lastName, patronymic, 20, passportSerial, login, password, 2));
//                userDao.insertUser(new User(firstName, lastName, patronymic, 20, passportSerial, login, password, Role.USER));

            } catch (SQLException e) {
                e.printStackTrace();
            }*/
        }


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ViewUtils.doView("registration", response, request);
    }
}