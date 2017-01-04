package com.gstu.mappers;


import com.gstu.executor.Mapper;
import com.gstu.models.Station;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StationMapper implements Mapper<Station> {

    private static final String ID_STATION = "idStation";
    private static final String NAME = "name";
    private static final String NAME_RU = "name_ru";

    @Override
    public Station processLine(ResultSet resultSet) throws SQLException {
        Station station = new Station();

        station.setIdStation(resultSet.getLong(ID_STATION));
        station.setName(resultSet.getString(NAME));
        station.setName_ru(resultSet.getString(NAME_RU));
        return station;

    }
}
