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
    private static final String SELECT_BY_DATE_QUERY = "SELECT * FROM train ... INNER JOIN schedule ... where date = ?";

    private static final String DELETE_BY_ID_QUERY = "DELETE FROM train WHERE idTrain = ?";

    public static final String INSERT_TRAIN = "INSERT INTO train (name,numberFreePlaces) VALUES (?,?) ";


    private Executor executor;

    public TrainDao(Executor executor) {
        this.executor = executor;
    }


    public void insertTrain(Train train){
        executor.execUpdate(INSERT_TRAIN,train.getName(),train.getNumberFreePlaces());
    }

    @Override
    public Train findById(Long id) {
        return executor.selectOne(SELECT_BY_ID_QUERY, new TrainMapper(), id);
    }

    @Override
    public List<Train> findAll() {
        return executor.selectList(SELECT_ALL_QUERY, new TrainMapper());
    }


    @Override
    public Train update(Train entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Train save(Train entity) {
        log.error(new UnsupportedOperationException());
        throw new UnsupportedOperationException();
    }

    @Override
    public Train deleteById(Long aLong) {
        executor.execUpdate(DELETE_BY_ID_QUERY, aLong);
        return null;
    }


}
