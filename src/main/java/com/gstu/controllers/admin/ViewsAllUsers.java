package com.gstu.controllers.admin;


import com.gstu.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/admin/users")
public class ViewsAllUsers extends HttpServlet {

    private UserService userService = new UserService();

    public ViewsAllUsers() throws SQLException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users",userService.getAllUsers());
        req.getRequestDispatcher("/WEB-INF/views/adminMenu/viewAllUsers.jsp").forward(req, resp);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService.deleteUserById(Long.parseLong(req.getParameter("Delete")));
        resp.sendRedirect("/admin-menu/views-all-users");
    }
}
