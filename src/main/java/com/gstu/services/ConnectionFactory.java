package com.gstu.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionFactory {

    private ConnectionFactory() {
        // Don't allow to create instances
    }

    private static volatile Connection connection;


    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection localInstance = connection;
        if (localInstance == null) {
            synchronized (ConnectionFactory.class) {
                localInstance = connection;
                if (localInstance == null) {
                    connection = localInstance = createConnection();
                }
            }
        }
        return localInstance;
    }

    private static Connection createConnection() {

        ResourceBundle properties = ResourceBundle.getBundle("settings");
        String url = properties.getString("url");
        String user = properties.getString("user");
        String password = properties.getString("password");

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
