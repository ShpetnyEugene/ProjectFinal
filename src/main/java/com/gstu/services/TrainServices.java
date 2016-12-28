package com.gstu.services;


import com.gstu.dao.TrainDao;
import com.gstu.executor.Executor;
import com.gstu.models.Train;

public class TrainServices {
    private static TrainDao trainDao = new TrainDao(new Executor(ConnectionFactory.getConnection()));


    public void addTrain(Train train){
        trainDao.insertTrain(train);
    }


}
