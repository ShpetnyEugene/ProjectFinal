package com.gstu.controllers;

import com.google.gson.Gson;
import com.gstu.dao.StationDao;
import com.gstu.models.Station;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/suggest/station")
public class SuggestionServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Station> stations;

        StationDao stationDao = new StationDao();
        stations = stationDao.findAll();

//        List<String> result = stations
//                .stream()
//                .map(Station::getName)
//                .collect(Collectors.toList());

//        List<String> result = stations
////                .stream()
////                .map(Station::getName)
////                .collect(Collectors.toList());
//

        Gson gson = new Gson();
        String json = gson.toJson(stations);

        resp.getWriter().print(json);
    }
}
