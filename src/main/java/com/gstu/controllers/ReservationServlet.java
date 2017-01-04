package com.gstu.controllers;


import com.gstu.dao.TrainDao;
import com.gstu.executor.Executor;
import com.gstu.services.ConnectionFactory;
import com.gstu.utils.ViewUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/order-tickets/reservation")
public class ReservationServlet extends HttpServlet {

    private TrainDao trainDao = new TrainDao(new Executor(ConnectionFactory.getConnection()));

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("schedules",req.getSession().getAttribute("list"));
        req.setAttribute("stationStart",req.getSession().getAttribute("stationStart"));
        req.setAttribute("stationEnd",req.getSession().getAttribute("stationEnd"));
        ViewUtils.doView("/booking/reservation",resp,req);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        RecordsTrainService recService = new RecordsTrainService();
//        recService.DeleteTrainById(Long.parseLong(req.getParameter("Delete")));
//        resp.sendRedirect("/admin/trains");


        ViewUtils.doView("/booking/reservation",resp,req);

    }
}
