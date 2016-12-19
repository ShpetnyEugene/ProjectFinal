package com.gstu.services.implementations;

import com.gstu.dao.TrainDao;
import com.gstu.factories.DaoFactory;
import com.gstu.models.Train;
import com.gstu.services.TrainService;

import java.util.List;

class TrainServiceImpl implements TrainService{

    private TrainDao trainDao;

    public TrainServiceImpl() {
        this.trainDao = DaoFactory.trainDao();
    }

    @Override
    public List<Train> allTrains() {
        return trainDao.findAll();
    }
}
