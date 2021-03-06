package com.gstu.controllers;


import com.gstu.utils.ViewUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/order-tickets")
public class OrderTicketsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String locale = (String) req.getSession().getAttribute("locale");
        if(locale == null || locale.equals("ru_RU")){
            req.setAttribute("name","name_ru");
        }else{
            req.setAttribute("name","name");
        }
        ViewUtils.doView("/booking/orderTickets", resp, req);
    }

}