package com.gstu.controllers;


import com.gstu.models.Schedule;
import com.gstu.models.Train;
import com.gstu.services.OrderTicketsService;
import com.gstu.services.ReservationService;
import com.gstu.services.TrainServices;
import com.gstu.utils.DateUtils;
import com.gstu.utils.ViewUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/order-tickets/reservation")
public class ReservationServlet extends HttpServlet {


    private TrainServices trainServices = new TrainServices();
    private OrderTicketsService orderTicketsService = new OrderTicketsService();
    private DateUtils dateUtils = new DateUtils();
    private ReservationService res = new ReservationService();



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ViewUtils.doView("/booking/reservation", resp, req);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String stationStart = req.getParameter("stationArrival");
        String stationEnd = req.getParameter("stationEnd");
        String dateStart = req.getParameter("date");


        long start = orderTicketsService.findId(stationStart);
        long end = orderTicketsService.findId(stationEnd);
        String date = dateUtils.changeFormatDate(dateStart);

        List<Schedule> schedules = res.showTrains(start, end, date);
        req.setAttribute("schedules",schedules);


        req.setAttribute("stationStart",stationStart);
        req.setAttribute("stationEnd",stationEnd);


        List<Train> trains = new ArrayList<>();

        for (Schedule s: schedules) {
            trains.add(trainServices.getTrainById(s.getTrain_idTrain()));
        }


        req.setAttribute("trains",trains);

        ViewUtils.doView("/booking/reservation", resp, req);

    }
}
