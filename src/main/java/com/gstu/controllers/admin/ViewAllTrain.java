package com.gstu.controllers.admin;

import com.gstu.services.TrainService;
import com.gstu.services.implementations.ServiceFactory;
import com.gstu.services.implementations.TrainServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/trains")

public class ViewAllTrain extends HttpServlet {
    private TrainService trainService;

    @Override
    public void init() throws ServletException {
        this.trainService = ServiceFactory.trainService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("trains", trainService.allTrains());
        request.getRequestDispatcher("/WEB-INF/views/adminMenu/viewAllTrain.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TrainServiceImpl recService = new TrainServiceImpl();
        recService.DeleteTrainById(Long.parseLong(req.getParameter("Delete")));
        resp.sendRedirect("/admin/trains");
    }
}
