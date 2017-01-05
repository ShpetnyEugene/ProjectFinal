package com.gstu.controllers;


import com.gstu.services.TrainServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/ticket-purchase")
public class TicketPurchase extends HttpServlet {
    private TrainServices trainServices = new TrainServices();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("order-tickets/reservation");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long idReservation = Long.parseLong(req.getParameter("reservation"));
        trainServices.decrementNumberFreePlaces(idReservation);
        resp.sendRedirect("order-tickets/reservation");
    }
}
