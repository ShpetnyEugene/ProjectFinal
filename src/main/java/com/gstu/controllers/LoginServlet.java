package com.gstu.controllers;

import com.gstu.models.User;
import com.gstu.services.UserService;
import com.gstu.services.implementations.ServiceFactory;
import com.gstu.utils.ViewUtils;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserService service;
    private Logger log = Logger.getLogger(LoginServlet.class);
    @Override
    public void init() throws ServletException {
        service = ServiceFactory.userService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ViewUtils.doView("login", response, request);
        System.out.println(request.getLocale());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = service.getUserByLogin(email);


        if (user != null && service.checkUserPassword(user, password)) {
            request.getSession().setAttribute("user", user);
            log.info("The user is logged in :");
            log.info(user);
            response.sendRedirect("/home");
        } else {

            ViewUtils.doView("login", response, request);
        }
    }
}