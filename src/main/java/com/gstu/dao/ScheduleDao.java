package com.gstu.dao;


import com.gstu.executor.Executor;
import com.gstu.mappers.ScheduleMapper;
import com.gstu.models.Schedule;
import com.gstu.services.ConnectionFactory;

import java.sql.SQLException;
import java.util.List;

public class ScheduleDao implements CrudDao<Schedule, Long> {

    private static final String QUERY = "SELECT  * FROM train INNER JOIN (station INNER JOIN schedule ON (station.idStation = schedule.stationEnd_idStation)) ON train.idTrain = schedule.train_idTrain\n" +
            "WHERE (((schedule.stationStart_idStation)=?) AND((schedule.stationEnd_idStation)=?) AND ((train.numberFreePlaces)<>0) AND ((schedule.departureTime)>?));";

    private Executor executor = new Executor(ConnectionFactory.getConnection());

    public List<Schedule> selectD(long start, long end, String date) {
        return executor.selectList(QUERY,new ScheduleMapper(),start,end,date);
    }

    @Override
    public Schedule findById(Long id) throws SQLException {
        return null;
    }

    @Override
    public List<Schedule> findAll() {
        return null;
    }

    @Override
    public Schedule update(Schedule entity) {
        return null;
    }

    @Override
    public Schedule save(Schedule entity) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }
}
