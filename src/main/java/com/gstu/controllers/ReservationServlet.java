package com.gstu.controllers;


import com.gstu.models.Schedule;
import com.gstu.models.Train;
import com.gstu.services.ReservationService;
import com.gstu.services.implementations.StationServiceImpl;
import com.gstu.services.implementations.TrainServiceImpl;
import com.gstu.utils.DateUtils;
import com.gstu.utils.ViewUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/order-tickets/booking")
public class ReservationServlet extends HttpServlet {


    private TrainServiceImpl trainServices = new TrainServiceImpl();
    private StationServiceImpl orderTicketsService = new StationServiceImpl();
    private DateUtils dateUtils = new DateUtils();
    private ReservationService res = new ReservationService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stationStart = req.getParameter("stationArrival");
        String stationEnd = req.getParameter("stationEnd");
        String dateStart = req.getParameter("date");

        long start = orderTicketsService.findId(stationStart);
        long end = orderTicketsService.findId(stationEnd);
        String date = dateUtils.changeFormatDate(dateStart);

        if (StringUtils.isBlank(stationStart)
                || StringUtils.isBlank(stationEnd)
                || StringUtils.isBlank(dateStart) ||  start == -1
                || end == -1) {
            ViewUtils.doView("/booking/reservation", resp, req);
            List<Schedule> schedules = res.selectionStation(start, end, date);
            req.setAttribute("schedules", schedules);
        }

        List<Schedule> schedules = res.selectionStation(start, end, date);
        req.setAttribute("schedules", schedules);

        req.setAttribute("stationStart", stationStart);
        req.setAttribute("stationEnd", stationEnd);

        List<Train> trains = schedules.stream()
                .map(s -> trainServices.getTrainById(s.getTrain_idTrain()))
                .collect(Collectors.toList());

        req.setAttribute("trains", trains);

        ViewUtils.doView("/booking/reservation", resp, req);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ViewUtils.doView("/booking/reservation", resp, req);
    }
}
