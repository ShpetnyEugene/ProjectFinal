package com.gstu.services;

import com.gstu.dao.TrainDao;
import com.gstu.executor.Executor;

import java.sql.SQLException;

public class RecordsTrainService {
    public void DeleteTrainById(long id){
        TrainDao trainDao = null;
        try {
            trainDao = new TrainDao(new Executor(DataBaseConnection.getInstance().getConnection()));
        } catch (SQLException e) {
            e.printStackTrace();
        }


        trainDao.deleteById(id);

    }
}
