package com.gstu.dao;

import com.gstu.executor.Executor;
import com.gstu.mappers.TrainMapper;
import com.gstu.models.Train;
import com.gstu.services.DataBaseConnection;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TrainDao implements CrudDao<Train, Long> {

    private static Logger log = Logger.getLogger(TrainDao.class);

    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM train WHERE idTrain = ?";

    private static final String SELECT_ALL_QUERY = "SELECT * FROM train";

    private static final String SELECT_BY_DATE_QUERY = "SELECT * FROM train ... INNER JOIN schedule ... where date = ?";

    private static final String DELETE_BY_ID_QUERY = "DELETE FROM train WHERE idTrain = ?";

    private com.gstu.executor.Executor executor;

    public TrainDao(Executor executor) {
        this.executor = executor;
    }


    @Override
    public Train findById(Long id) {
        return executor.selectOne(SELECT_BY_ID_QUERY, new TrainMapper(), id);
    }

    // Работает
    @Override
    public List<Train> findAll() {
        return executor.selectList(SELECT_ALL_QUERY, new TrainMapper());
    }

    @Override
    // TODO ОБНОВЛЕНИЕ ИНФОРМАЦИИ
    public Train update(Train entity) {
        DataBaseConnection dataBaseConnection = null;
        try {
            dataBaseConnection = DataBaseConnection.getInstance();

        } catch (SQLException e) {
            log.error(e);
            // FIXME: 11.12.2016 Пустое сообщение
            throw new DataAccessException("", e);
        }

        Connection connection = dataBaseConnection.getConnection();

        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM train")) {
            entity.getIdTrain();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
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
