package com.gstu.services;


import com.gstu.dao.StationDao;

public class OrderTicketsService {

    private StationDao stationDao = new StationDao();

    /**
     * @param name - Name Station which need to find the id
     * @return id station where Name Station coincides name
     * */
    public long findId(String name){
        return stationDao.findIdByName(name).getIdStation();
    }

}
