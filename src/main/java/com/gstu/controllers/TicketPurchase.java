package com.gstu.controllers;


import com.gstu.models.User;
import com.gstu.services.ReservationService;
import com.gstu.services.implementations.TrainServiceImpl;
import com.gstu.utils.ViewUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/ticket-purchase")
public class TicketPurchase extends HttpServlet {

    private TrainServiceImpl trainServices = new TrainServiceImpl();
    private ReservationService reservationService = new ReservationService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("order-tickets/reservation");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long idReservation = Long.parseLong(req.getParameter("reservation"));
        trainServices.decrementNumberFreePlaces(idReservation);

        User user = (User)req.getSession().getAttribute("user");

        reservationService.insertTicket(user.getIdUser());

        ViewUtils.doView("/booking/reservation", resp, req);

        //TODO А также выводилось что билет заказан
    }
}
