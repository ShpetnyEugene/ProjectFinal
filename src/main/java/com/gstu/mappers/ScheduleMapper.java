package com.gstu.mappers;

import com.gstu.executor.Mapper;
import com.gstu.models.Schedule;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;


public class ScheduleMapper implements Mapper<Schedule> {

    private static final String DEPARTURE_TIME = "departureTime";
    private static final String ARRIVAL_TIME = "arrivalTime";
    private static final String PRICE = "price";
    private static final String STATION_START_ID = "stationStart_idstation";
    private static final String STATION_END_ID = "stationEnd_idstation";
    private static final String SCHEDULE_ID = "schedulId";
    private static final String TRAIN_ID = "train_idTrain";



    @Override
    public Schedule processLine(ResultSet resultSet) throws SQLException {
        Schedule schedule = new Schedule();

        schedule.setScheduleId(resultSet.getLong(SCHEDULE_ID));
        Timestamp timestamp =  resultSet.getTimestamp(ARRIVAL_TIME);
        schedule.setArrivalTime(timestamp);
        Timestamp timestamp1 = (resultSet.getTimestamp(DEPARTURE_TIME));
        schedule.setDepartureTime(timestamp1);
        schedule.setPrice(resultSet.getInt(PRICE));
        schedule.setTrain_idTrain(resultSet.getLong(TRAIN_ID));
        schedule.setStationEndId(resultSet.getLong(STATION_START_ID));
        schedule.setStationEndId(resultSet.getLong(STATION_END_ID));

        return schedule;
    }
}
