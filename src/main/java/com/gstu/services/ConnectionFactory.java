package com.gstu.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private ConnectionFactory() {
        // Don't allow to create instances
    }

    private static volatile Connection connection;

    public static Connection getConnection() {
        Connection localInstance = connection;
        if (localInstance == null) {
            synchronized (DataBaseConnection.class) {
                localInstance = connection;
                if (localInstance == null) {

                    connection = localInstance = createConnection();
                }
            }
        }
        return localInstance;
    }

    private static Connection createConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/railwaydb", "root", "5674");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
