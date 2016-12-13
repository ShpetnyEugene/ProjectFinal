package com.gstu.controllers;

import com.gstu.models.User;
import com.gstu.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(LoginServlet.class);
    private final static String ERROR_MESSAGE = "don't valid email or password";
    private UserService service = new UserService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        toView(request,response,"login");
    }

    private void toView(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/" + view + ".jsp").forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");


        if(email==null || password == null) {
            request.setAttribute("error", ERROR_MESSAGE);
            toView(request, response, "login");
        }

        if(service.checkUserPassword(email, password)) {
            User user = service.getUserByEmail(email);
            request.getSession().setAttribute("user", user );

            response.sendRedirect(request.getContextPath());
        } else {
            request.setAttribute("error", ERROR_MESSAGE);
            toView(request, response, "login");
        }

    }
}