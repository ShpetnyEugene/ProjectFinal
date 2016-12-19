package com.gstu.factories;

import com.gstu.dao.TrainDao;
import com.gstu.executor.Executor;
import com.gstu.services.DataBaseConnection;

import java.sql.SQLException;

public class DaoFactory {

    private static Executor executor;

    private DaoFactory() {
        // don't allow instance this class
    }

    public static TrainDao trainDao() {

        try {
            Executor executor = new Executor(DataBaseConnection.getInstance().getConnection());
            return new TrainDao(executor);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
