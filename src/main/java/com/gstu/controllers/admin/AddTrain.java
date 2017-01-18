package com.gstu.controllers.admin;


import com.gstu.models.Train;
import com.gstu.services.implementations.TrainServiceImpl;
import com.gstu.utils.ViewUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/trains/add")
public class AddTrain extends HttpServlet {

    private static final String NAME = "name";

    private static final String NUMBER_FREE_PLACES = "numberFreePlaces";

    private static Logger log = Logger.getLogger(AddTrain.class);
    private static TrainServiceImpl trainServices = new TrainServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter(NAME);
        String numberFreePlaces = req.getParameter(NUMBER_FREE_PLACES);

        int number = -1;

        if (StringUtils.isBlank(name) || StringUtils.isBlank(numberFreePlaces)) {
            resp.sendRedirect("/admin/trains/add");
        } else {
            try {
                number = Integer.parseInt(numberFreePlaces);
            } catch (Exception e) {
                log.error(e);
            }
            if (number > 0) {
                trainServices.addTrain(new Train(name, number));
                req.setAttribute("successfully",1);
            }
            ViewUtils.doView("adminMenu/addTrain", resp, req);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ViewUtils.doView("adminMenu/addTrain", resp, req);
    }
}
