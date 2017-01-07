package com.gstu.mappers;

import com.gstu.executor.Mapper;
import com.gstu.models.Train;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TrainMapper implements Mapper<Train> {

    private static final String ID_TRAIN = "idTrain";

    private static final String NAME = "name";

    private static final String NUMBER_FREE_PLACES =  "numberFreePlaces";


    @Override
    public Train processLine(ResultSet resultSet) throws SQLException {
        Train train = new Train();

        train.setIdTrain(resultSet.getLong(ID_TRAIN));
        train.setName(resultSet.getString(NAME));
        train.setNumberFreePlaces(resultSet.getInt(NUMBER_FREE_PLACES));

        return train;
    }
}
