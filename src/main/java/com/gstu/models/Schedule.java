package com.gstu.models;


import java.util.Date;

public class Schedule {
    // TODO ВАЖНО НАПИСАТЬ по БД
    private int scheduleId;
    private Date arrivalTime;
    private Date departureTime;
    private int price;
    // TODO Или писать навзвание станций
    private int stationStartId;
    private int stationEndId;

}