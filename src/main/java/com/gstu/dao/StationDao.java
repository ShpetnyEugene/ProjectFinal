package com.gstu.dao;

import com.gstu.executor.Executor;
import com.gstu.mappers.StationMapper;
import com.gstu.models.Station;
import com.gstu.services.ConnectionFactory;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class StationDao implements CrudDao<Station, Long> {

    private static Logger log = Logger.getLogger(Station.class);


    private static final String SELECT_ALL_QUERY = "SELECT * FROM station";

    private static final String SELECT_BY_ID = "SELECT * FROM station WHERE idStation = ?";

    private static final String DELETE_BY_ID = "DELETE FROM station WHERE idStation = ?";

    private static final String SELECT_ID_BY_NAME = "SELECT * FROM station WHERE name = ?  ";

    private static final String SELECT_ID_BY_NAME_RU = "SELECT * FROM station WHERE name_ru = ?";


    private Executor executor = new Executor(ConnectionFactory.getConnection());


    public Station findIdByName(String name){
        return executor.selectOne(SELECT_ID_BY_NAME,new StationMapper(),name);
    }

    public Station findIdByNameRu(String name){
        return executor.selectOne(SELECT_ID_BY_NAME_RU,new StationMapper(),name);
    }

    @Override
    public Station findById(Long id) throws SQLException {
        return executor.selectOne(SELECT_BY_ID, new StationMapper(), id);

    }

    @Override
    public List<Station> findAll() {
        return executor.selectList(SELECT_ALL_QUERY, new StationMapper());

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
    public void deleteById(Long aLong) {
        executor.execUpdate(DELETE_BY_ID,aLong);
    }
}
