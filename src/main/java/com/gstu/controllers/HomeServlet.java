package com.gstu.controllers;

import com.gstu.utils.ViewUtils;
import org.apache.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(HomeServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ViewUtils.doView("home",response,request);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        ViewUtils.doView("home",resp,req);
    }
}