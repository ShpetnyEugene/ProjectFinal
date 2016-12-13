package com.gstu.controllers;


import com.gstu.dao.TrainDao;
import com.gstu.models.Train;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/booking/ViewsAllStation")
public class ViesStationsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Print(req,resp);
    }

    protected void Print(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TrainDao trainDao = new TrainDao();
        List<Train> trains = new ArrayList<>();
        trains = trainDao.findAll();


        req.setAttribute("trains",trains);
        req.getRequestDispatcher("/WEB-INF/views/booking/ViewsAllStation.jsp").forward(req, resp);
    }
}



