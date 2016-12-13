package com.gstu.dao;

import com.gstu.models.Train;
import com.gstu.services.DataBaseConnection;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrainDao implements CrudDao<Train, Long> {

    private static Logger log = Logger.getLogger(TrainDao.class);
    private static final String ID_TRAIN = "idTrain";
    private static final String NAME = "name";
    private static final String NUMBER_FREE_PLACES =  "numberFreePlaces";


    private Executor executor;

    /*public TrainDao(Connection connection) {
        this.executor = new Executor(connection);
    }
*/

    @Override
    public Train findById(Long id) {
        DataBaseConnection dataBaseConnection = null;
        Train train = null;
        try {
            dataBaseConnection = DataBaseConnection.getInstance();
        } catch (SQLException e) {
            log.error(e);
            // FIXME: 11.12.2016
            throw new DataAccessException("",e);
        }

        Connection connection = dataBaseConnection.getConnection();

        try(PreparedStatement statement = connection.prepareStatement("select * from train WHERE idTrain = ?")) {

            statement.setLong(1,id);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            train = new Train(resultSet.getInt(ID_TRAIN), resultSet.getString(NAME), resultSet.getInt(NUMBER_FREE_PLACES));

        } catch (SQLException e) {
            log.error(e);
            throw new DataAccessException("Train with id not found" + id, e);
        }
        return train;


       /* try {
           return executor.execQuery("select * from train WHERE idTrain = " + id,resultSet -> {
                resultSet.next();
                return new Train(resultSet.getLong(ID_TRAIN), resultSet.getString(NAME), resultSet.getInt(NUMBER_FREE_PLACES));
            });
        } catch (SQLException e) {
            // FIXME: 12.12.2016 ОШИБКУ ОБРАБОТАТЬ
            e.printStackTrace();
        }
        return null;*/
    }

    @Override
    public List<Train> findAll() {
        List<Train> trains = new ArrayList<>();

        DataBaseConnection dataBaseConnection = null;
        try {
            dataBaseConnection = DataBaseConnection.getInstance();
        } catch (SQLException e) {
            log.error(e);
            // FIXME: 11.12.2016 ПУстое сообщение
            throw new DataAccessException("",e);
        }

        Connection connection = dataBaseConnection.getConnection();

        try(PreparedStatement statement = connection.prepareStatement("select * from train")) {

            ResultSet resultSet = statement.executeQuery();


            while (resultSet.next()) {
                trains.add(new Train(
                        resultSet.getInt(ID_TRAIN),
                        resultSet.getString(NAME),
                        resultSet.getInt(NUMBER_FREE_PLACES))
                );

            }
        } catch (SQLException e) {
            log.error(e);
            // FIXME: 11.12.2016 String исправить возможно
            throw new DataAccessException("Trains have found", e);
        }
        return trains; 
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
            throw new DataAccessException("",e);
        }

        Connection connection = dataBaseConnection.getConnection();

        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM train")){
            entity.getId();

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
        // TODO возвращаемый тип можно же просто void
        DataBaseConnection dataBaseConnection = null;
        try {
            dataBaseConnection = DataBaseConnection.getInstance();
        } catch (SQLException e) {
            log.error(e);
            // FIXME: 11.12.2016
            throw new DataAccessException("", e);
        }
        Connection connection = dataBaseConnection.getConnection();
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM train WHERE idTrain= ?")) {

        } catch (SQLException e) {
            log.error(e);
            throw new DataAccessException("Train with id not found" + ID_TRAIN, e);
        }
        return null;
    }
}
