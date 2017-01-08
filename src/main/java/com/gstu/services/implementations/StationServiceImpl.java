package com.gstu.services.implementations;


import com.gstu.dao.StationDao;
import com.gstu.executor.Executor;
import com.gstu.services.ConnectionFactory;
import com.gstu.services.StationService;

public class StationServiceImpl implements StationService {

    private StationDao stationDao;

    public StationServiceImpl() {
        this.stationDao = new StationDao(new Executor(ConnectionFactory.getConnection()));
    }

    /**
     * Finds going station by given name
     *
     * @param name - Name Station which need to find the id
     * @return id station where Name Station coincides name or -1 if station not found
     */
    @Override
    public long findId(String name) {
        if (stationDao.findIdByName(name) != null) {
            return stationDao.findIdByName(name).getIdStation();
        }else{
            return -1;
        }
    }
}
