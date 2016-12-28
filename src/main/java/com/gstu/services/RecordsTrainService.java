package com.gstu.services;

import com.gstu.dao.TrainDao;
import com.gstu.executor.Executor;

public class RecordsTrainService {
    public void DeleteTrainById(long id) {
        TrainDao trainDao = null;
        trainDao = new TrainDao(new Executor(ConnectionFactory.getConnection()));
        trainDao.deleteById(id);

    }
}
