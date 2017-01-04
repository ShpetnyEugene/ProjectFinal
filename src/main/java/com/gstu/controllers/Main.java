package com.gstu.controllers;

import com.gstu.dao.StationDao;

public class Main {
    public static void main(String[] args)  {
        StationDao stationDao = new StationDao();

        System.out.println(stationDao.findAll());
    }
}
