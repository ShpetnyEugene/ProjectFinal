package com.gstu.services;

import com.gstu.dao.TrainDao;
import com.gstu.executor.Executor;
import com.gstu.models.Train;

/**
 * @author Shpetny Eugene
 * @version 1.0
 * */
public class TrainServices {
    private static TrainDao trainDao = new TrainDao(new Executor(ConnectionFactory.getConnection()));

    /**
     * Adding a new train to the database
     *
     * @param train - are added to the database
     */
    public void addTrain(Train train){
        trainDao.insertTrain(train);
    }
}
