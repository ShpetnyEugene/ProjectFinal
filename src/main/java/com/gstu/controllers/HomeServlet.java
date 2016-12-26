package com.gstu.controllers;

import com.gstu.services.RecordsTrainService;
import com.gstu.services.TrainService;
import com.gstu.services.implementations.ServiceFactory;
import com.gstu.utils.ViewUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    private TrainService trainService;

    @Override
    public void init() throws ServletException {
        this.trainService = ServiceFactory.trainService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        User user = (User) request.getAttribute("user");
//

//        User user1 = (User) request.getSession().getAttribute("user");
        request.setAttribute("trains", trainService.allTrains());
        request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("----------------------------------");

        System.out.println(req.getParameter("Delete"));
        RecordsTrainService recService = new RecordsTrainService();
        recService.DeleteTrainById(Long.getLong(req.getParameter("Delete")));
        ViewUtils.doView("home",resp,req);

    }
}