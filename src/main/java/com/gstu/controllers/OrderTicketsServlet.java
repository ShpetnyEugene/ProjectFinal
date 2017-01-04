package com.gstu.controllers;


import com.gstu.utils.ViewUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/order-tickets")
public class OrderTicketsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ViewUtils.doView("/booking/orderTickets",resp,req);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String stationStart = req.getParameter("stationArrival");
        String stationEnd = req.getParameter("stationEnd");
        String dateStart = req.getParameter("date");

        System.out.println(stationStart);
        System.out.println(stationEnd);
        System.out.println(dateStart);

        // по названию станций я найду все id, потом пробегу и найду,все расписание прибытие поездов с
        // чтобы id начальной станции равноляось id станции переменная направления равна 1




        ViewUtils.doView("/booking/orderTickets",resp,req);


    }
}