package com.gstu.dao;

import com.gstu.models.Station;
import com.gstu.services.ConnectionFactory;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StationDao implements CrudDao<Station, Long> {

    private static Logger log = Logger.getLogger(Station.class);
    private static final String ID_STATION = "idStation";
    private static final String NAME = "name";


    @Override
    public Station findById(Long id) throws SQLException {
        Station station;
        Connection connection = ConnectionFactory.getConnection();

        try (PreparedStatement statement = connection.prepareStatement("select * from station WHERE idStation = ?")) {

            //statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            station = new Station(resultSet.getLong(ID_STATION), resultSet.getString(NAME));
        } catch (SQLException e) {
            log.error(e);
            throw new DataAccessException("Station with id not found " + id, e);
        }
        return station;
    }

    @Override
    public List<Station> findAll() {
        List<Station> stations = new ArrayList<>();
        Connection connection = ConnectionFactory.getConnection();

        try (PreparedStatement statement = connection.prepareStatement("select * from station")) {

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            stations.add(new Station(resultSet.getLong(ID_STATION), resultSet.getString(NAME)));
        } catch (SQLException e) {
            log.error(e);
            throw new DataAccessException("Stations not found ", e);
        }
        return stations;

    }

    @Override
    public Station update(Station entity) {
        return null;
    }

    @Override
    public Station save(Station entity) {
        return null;
    }

    @Override
    public Station deleteById(Long aLong) {

        Connection connection = ConnectionFactory.getConnection();
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM station WHERE idStation= ?")) {

        } catch (SQLException e) {
            log.error(e);
            throw new DataAccessException("Train with id not found" + aLong, e);
        }
        return null;
    }
}
