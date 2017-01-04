package com.gstu.controllers;


import com.gstu.models.Schedule;
import com.gstu.services.OrderTicketsService;
import com.gstu.services.Reservation;
import com.gstu.services.TrainServices;
import com.gstu.utils.DateUtils;
import com.gstu.utils.ViewUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/order-tickets")
public class OrderTicketsServlet extends HttpServlet {

    private OrderTicketsService orderTicketsService = new OrderTicketsService();
    private DateUtils dateUtils = new DateUtils();
    private Reservation res = new Reservation();
    private TrainServices trainServices = new TrainServices();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ViewUtils.doView("/booking/orderTickets", resp, req);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String stationStart = req.getParameter("stationArrival");
        String stationEnd = req.getParameter("stationEnd");
        String dateStart = req.getParameter("date");


        long start = orderTicketsService.findId(stationStart);
        long end = orderTicketsService.findId(stationEnd);
        String date = dateUtils.changeFormatDate(dateStart);


        List<Schedule> list = res.showTrains(start, end, date);
        req.getSession().setAttribute("list",list);
        req.getSession().setAttribute("stationStart",stationStart);
        req.getSession().setAttribute("stationEnd",stationEnd);

        ViewUtils.doView("/booking/orderTickets", resp, req);
    }
}