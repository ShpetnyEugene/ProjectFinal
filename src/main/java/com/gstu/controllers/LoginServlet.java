package com.gstu.controllers;

import com.gstu.models.User;
import com.gstu.services.UserService;
import com.gstu.utils.ViewUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

  //  private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(LoginServlet.class);
    private UserService service = new UserService();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ViewUtils.doView("login",response,request);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO заменить на Login
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = service.getUserByLogin(email);

        if (user != null && service.checkUserPassword(user,password)){
            request.getSession().setAttribute("user", user );

            // TODO ПЕРЕнаправление на страницу
            response.sendRedirect("/home");
        }else {

            ViewUtils.doView("login",response,request);
        }
    }
}