package com.gstu.services;

import com.gstu.dao.ScheduleDao;
import com.gstu.models.Schedule;

import java.util.List;

public class ReservationService {

    private static ScheduleDao scheduleDao = new ScheduleDao();

    public List<Schedule> showTrains(long stationStart_idStation, long stationEnd_idStation, String departureTime) {
        return scheduleDao.selectD(stationStart_idStation,stationEnd_idStation,departureTime);
    }

}