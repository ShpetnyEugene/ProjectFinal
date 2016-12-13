package com.gstu.services;


import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DataBaseConnection {

    private static Logger log = Logger.getLogger(DataBaseConnection.class);

    private static volatile DataBaseConnection instance;

    private Connection connection;

    public static DataBaseConnection getInstance() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        DataBaseConnection localInstance = instance;
        if (localInstance == null) {
            synchronized (DataBaseConnection.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DataBaseConnection();
                }
            }
        }
        return localInstance;
    }

    private DataBaseConnection()  {
        ResourceBundle properties = ResourceBundle.getBundle("settings");
        String url = properties.getString("url");
        String user = properties.getString("user");
        String password = properties.getString("password");

        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            log.error(e);
            throw new RuntimeException(e);
        }
    }

    public synchronized Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection co = DriverManager.getConnection("jdbc:mysql://localhost:3306/railwaydb","root","5674");
            return co;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
