package com.gstu.controllers;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/booking/ViewsAllStation")
public class ViesStationsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Print(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void Print(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        req.getRequestDispatcher("/WEB-INF/views/booking/ViewsAllStation.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String date = req.getParameter("arrivalDate");

    }
}