package com.gstu.factories;

import com.gstu.dao.TrainDao;
import com.gstu.executor.Executor;
import com.gstu.services.ConnectionFactory;

public class DaoFactory {

    private static Executor executor;

    private DaoFactory() {
        // don't allow instance this class
    }

    public static TrainDao trainDao() {
        Executor executor = new Executor(ConnectionFactory.getInstance().getConnection());
        return new TrainDao(executor);
    }

}
