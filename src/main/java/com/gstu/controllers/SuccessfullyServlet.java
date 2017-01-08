package com.gstu.controllers;

import com.gstu.utils.ViewUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/successfully")
public class SuccessfullyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("number", req.getSession().getAttribute("accountNumber"));
        req.setAttribute("price",req.getSession().getAttribute("price"));
        ViewUtils.doView("/booking/successfully", resp, req);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ViewUtils.doView("/booking/successfully", resp, req);
    }
}
