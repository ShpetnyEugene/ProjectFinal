package com.gstu.dao;

import com.gstu.executor.Executor;
import com.gstu.mappers.TrainMapper;
import com.gstu.models.Train;
import org.apache.log4j.Logger;

import java.util.List;

public class TrainDao implements CrudDao<Train, Long> {

    private static Logger log = Logger.getLogger(TrainDao.class);

    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM train WHERE idTrain = ?";

    private static final String SELECT_ALL_QUERY = "SELECT * FROM train";


    // TODO Самый главный запр
    private static final String SELECT_BY_DATE_QUERY = "SELECT  * FROM train " +
            "INNER JOIN (station INNER JOIN schedule ON (station.idStation = schedule.stationEnd_idStation1)) ON train.idTrain = schedule.train_idTrain\n" +
            "WHERE (((schedule.order)=1)" +
            " AND ((schedule.stationEnd_idStation1)=2) " +
            " AND ((train.numberFreePlaces)<>0) " +
            "AND ((schedule.departureTime)>11/12/2015)) AND ((schedule.stationStart_idStation)=1);";

    private static final String DELETE_BY_ID_QUERY = "DELETE FROM train WHERE idTrain = ?";

    public static final String INSERT_TRAIN = "INSERT INTO train (name,numberFreePlaces) VALUES (?,?) ";


    private Executor executor;

    public TrainDao(Executor executor) {
        this.executor = executor;
    }


    /**
     * Adding a new train to the database
     *
     * @param train - are added to the database
     */
    public void insertTrain(Train train){
        executor.execUpdate(INSERT_TRAIN,train.getName(),train.getNumberFreePlaces());
    }


    /**
     * Find train by id.
     * Find train in database if user not found return null.
     *
     * @param id Trains who need to find
     * @return Train with the given id
     */
    @Override
    public Train findById(Long id) {
        return executor.selectOne(SELECT_BY_ID_QUERY, new TrainMapper(), id);
    }


    /**
     * Find all train
     * Find trains in database if users not found returns null, else returns List<Train>
     *
     * @return a list of users
     */
    @Override
    public List<Train> findAll() {
        return executor.selectList(SELECT_ALL_QUERY, new TrainMapper());
    }

    /**
     * The method is not supported
     *
     * @throws UnsupportedOperationException, when calling
     */
    @Override
    public Train update(Train entity) {
        log.error(new UnsupportedOperationException());
        throw new UnsupportedOperationException();
    }

    /**
     * The method is not supported
     *
     * @throws UnsupportedOperationException, when calling
     */
    @Override
    public Train save(Train entity) {
        log.error(new UnsupportedOperationException());
        throw new UnsupportedOperationException();
    }
    /**
     * Delete train by id
     *
     * @param aLong - id of the train you want to remove
     */
    @Override
    public void deleteById(Long aLong) {
        executor.execUpdate(DELETE_BY_ID_QUERY, aLong);
    }
}
