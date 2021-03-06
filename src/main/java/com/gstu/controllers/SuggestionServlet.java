package com.gstu.controllers;

import com.google.gson.Gson;
import com.gstu.dao.StationDao;
import com.gstu.executor.Executor;
import com.gstu.models.Station;
import com.gstu.services.ConnectionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/suggest/station")
public class SuggestionServlet extends HttpServlet{

    StationDao stationDao;
    @Override
    public void init() throws ServletException {
        this.stationDao = new StationDao(new Executor(ConnectionFactory.getInstance().getConnection()));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        List<Station> stations = stationDao.findAll();
        resp.setContentType("text/html; charset=UTF-8");
        String json = gson.toJson(stations);
        resp.getWriter().print(json);
    }
}
