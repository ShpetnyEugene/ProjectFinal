package com.gstu.services;

import com.gstu.dao.ScheduleDao;
import com.gstu.dao.TicketDao;
import com.gstu.models.Schedule;

import java.util.List;

public class ReservationService {

    private static ScheduleDao scheduleDao = new ScheduleDao();
    private static TicketDao ticketDao = new TicketDao();

    /**
     * Find the list of stations for the user by the user specified parameters Station Arrival, station departure and departure time
     *
     * @return List of stations found, according to user-specified parameters
     */

    public List<Schedule> selectionStation(long stationStart_idStation, long stationEnd_idStation, String departureTime) {
        return scheduleDao.selectD(stationStart_idStation, stationEnd_idStation, departureTime);
    }

    /**
     * Adds a user ID in the database
     *
     * @param id - The user ID that you want to add
     * @return The amount of added tickets
     */
    public int insertTicket(long id) {
        return ticketDao.insertTicket(id);
    }
}