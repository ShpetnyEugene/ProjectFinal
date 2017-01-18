package com.gstu.controllers;

import com.gstu.utils.ViewUtils;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/successfully")
public class SuccessfullyServlet extends HttpServlet {
    private static Logger log = Logger.getLogger(SuccessfullyServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("number", req.getSession().getAttribute("accountNumber"));
        req.setAttribute("price",req.getSession().getAttribute("price"));
        log.info("User successfully order ticket");
        log.info(req.getSession().getAttribute("user"));
        ViewUtils.doView("/booking/successfully", resp, req);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ViewUtils.doView("/booking/successfully", resp, req);
    }
}
