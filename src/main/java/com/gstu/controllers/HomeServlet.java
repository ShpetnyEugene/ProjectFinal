package com.gstu.controllers;

import com.gstu.services.TrainService;
import com.gstu.services.implementations.ServiceFactory;
import com.gstu.utils.ViewUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    private TrainService trainService;

    @Override
    public void init() {
        this.trainService = ServiceFactory.trainService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ViewUtils.doView("home",response,request);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        ViewUtils.doView("home",resp,req);
    }
}