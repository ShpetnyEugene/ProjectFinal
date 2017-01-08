package com.gstu.dao;


import com.gstu.executor.Executor;
import com.gstu.mappers.ScheduleMapper;
import com.gstu.models.Schedule;
import com.gstu.services.ConnectionFactory;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class ScheduleDao implements CrudDao<Schedule, Long> {

    private Logger log = Logger.getLogger(Schedule.class);

    private static final String QUERY = "SELECT  * FROM train INNER JOIN (station INNER JOIN schedule ON (station.idStation = schedule.stationEnd_idStation)) ON train.idTrain = schedule.train_idTrain\n" +
            "WHERE (((schedule.stationStart_idStation)=?) AND((schedule.stationEnd_idStation)=?) AND ((train.numberFreePlaces)<>0) AND ((schedule.departureTime)>?));";


    private static final String FIND_PRICE_BY_ID = "SELECT * FROM train INNER JOIN schedule ON train.idTrain = schedule.train_idTrain WHERE train.idTrain = ?";

    private Executor executor = new Executor(ConnectionFactory.getConnection());


    public List<Schedule> selectD(long start, long end, String date) {
        return executor.selectList(QUERY, new ScheduleMapper(), start, end, date);
    }

    /**
     * The method is not supported
     *
     * @throws UnsupportedOperationException, when calling
     */
    @Override
    public Schedule findById(Long id) throws SQLException {
        log.error(new UnsupportedOperationException());
        throw new UnsupportedOperationException();
    }

    /**
     * The method is not supported
     *
     * @throws UnsupportedOperationException, when calling
     */
    @Override
    public List<Schedule> findAll() {
        log.error(new UnsupportedOperationException());
        throw new UnsupportedOperationException();
    }

    /**
     * The method is not supported
     *
     * @throws UnsupportedOperationException, when calling
     */
    @Override
    public Schedule update(Schedule entity) {
        log.error(new UnsupportedOperationException());
        throw new UnsupportedOperationException();
    }

    /**
     * The method is not supported
     *
     * @throws UnsupportedOperationException, when calling
     */
    @Override
    public Schedule save(Schedule entity) {
        log.error(new UnsupportedOperationException());
        throw new UnsupportedOperationException();
    }

    /**
     * The method is not supported
     *
     * @throws UnsupportedOperationException, when calling
     */
    @Override
    public void deleteById(Long aLong) {
        log.error(new UnsupportedOperationException());
        throw new UnsupportedOperationException();
    }

    public Schedule findPriceById(long id){
        return executor.selectOne(FIND_PRICE_BY_ID,new ScheduleMapper(),id);
    }
}
