package com.gstu.controllers;

import com.gstu.models.Role;
import com.gstu.models.User;
import com.gstu.services.UserService;
import com.gstu.utils.ViewUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;




@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private static Logger log = Logger.getLogger(RegistrationServlet.class);

    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String PATRONYMIC = "patronymic";
    private static final String IDENTIFICATION_NUMBER = "identificationNumber";
    private static final String BIRTHDAY = "birthDay";

    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter(FIRST_NAME);
        String lastName = req.getParameter(LAST_NAME);
        String patronymic = req.getParameter(PATRONYMIC);
        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);
        String identificationNumber = req.getParameter(IDENTIFICATION_NUMBER);
        String birthDay = req.getParameter(BIRTHDAY);


        String errorMessages = "";

        String locale = String.valueOf((req.getSession().getAttribute("locale")));

        if ((StringUtils.isBlank(lastName)
                || StringUtils.isBlank(firstName) || StringUtils.isBlank(patronymic)
                || StringUtils.isBlank(password) || StringUtils.isBlank(login)
                || StringUtils.isBlank(birthDay) || StringUtils.isBlank(identificationNumber))) {
            if (locale.equals("ru_RU")) {
                errorMessages += "Все поля обязательно должны быть заполнены !";
            } else {
                errorMessages += "All fields must be filled!";
            }
            req.setAttribute("error", errorMessages);
            ViewUtils.doView("registration", resp, req);
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy");
        java.util.Date date = null;
        try {
            date = dateFormat.parse(birthDay);
        } catch (ParseException e) {
            log.error(e);
            e.printStackTrace();
        }
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        Date birthdayDate = Date.valueOf(dateFormat1.format(date));


        if (!userService.addUser(new User(firstName, lastName, patronymic, birthdayDate, identificationNumber, login, password, Role.USER))) {
            errorMessages = "1";
            req.setAttribute("error", errorMessages);
            ViewUtils.doView("registration", resp, req);
        } else {

            resp.sendRedirect("/login");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ViewUtils.doView("registration", response, request);
    }
}