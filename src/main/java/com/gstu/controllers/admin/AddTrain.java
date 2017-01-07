package com.gstu.controllers.admin;


import com.gstu.models.Train;
import com.gstu.services.implementations.TrainServiceImpl;
import com.gstu.utils.ViewUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/trains/add")
public class AddTrain extends HttpServlet{

    private static final String NAME = "name";
    private static final String NUMBER_FREE_PLACES = "numberFreePlaces";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter(NAME);
        String numberFreePlaces = req.getParameter(NUMBER_FREE_PLACES);

        TrainServiceImpl trainServices = new TrainServiceImpl();
        trainServices.addTrain(new Train(name,Integer.parseInt(numberFreePlaces)));

        ViewUtils.doView("adminMenu/addTrain",resp,req);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ViewUtils.doView("adminMenu/addTrain",resp,req);
    }
}
