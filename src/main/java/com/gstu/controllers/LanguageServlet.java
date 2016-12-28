package com.gstu.controllers;

import com.gstu.utils.ViewUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/config/language")
public class LanguageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ViewUtils.doView(req.getRequestURI(), resp, req);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String locale = req.getParameter("local");

        System.out.println(locale);


        System.out.println(req.getContextPath());
        System.out.println(req.getRequestURI());
        System.out.println(req.getRequestURL());

        if (locale.equals("rus")){
            req.getSession().setAttribute("locale","ru_RU");
        }else{
            req.getSession().setAttribute("locale","en_EN");
        }

        //resp.sendRedirect(req.getRequestURI());

        ViewUtils.doView(req.getRequestURI(),resp,req);
    }
}
