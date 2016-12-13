package com.gstu.controllers;

import com.gstu.dao.TrainDao;
import com.gstu.models.Train;

import java.sql.SQLException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws SQLException {
        TrainDao trainDao = new TrainDao();
        List<Train> trains = trainDao.findAll();

        for (Train tr: trains ) {
            System.out.println(tr.getId() + " " + tr.getName());
        }

    }
}
