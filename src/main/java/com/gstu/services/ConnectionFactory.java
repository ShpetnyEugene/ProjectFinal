package com.gstu.services;

import org.apache.commons.dbcp2.BasicDataSource;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionFactory {

    private ConnectionFactory() {
        // Don't allow to create instances
    }

    private static BasicDataSource ds;

    private static BasicDataSource init() throws IOException, SQLException, PropertyVetoException {

        ResourceBundle properties = ResourceBundle.getBundle("settings");
        String url = properties.getString("url");
        String user = properties.getString("user");
        String password = properties.getString("password");

        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUsername(user);
        ds.setPassword(password);
        ds.setUrl(url);

        // the settings below are optional -- dbcp can work with defaults
        ds.setMinIdle(5);
        ds.setMaxIdle(20);
        ds.setMaxOpenPreparedStatements(180);

        return ds;
    }

    public static Connection getConnection() {

        Connection connection;
        try {
            if (ds == null) {
                ds = init();
            }
            connection = ds.getConnection();
        } catch (Exception ex) {
            throw new RuntimeException("Connection exception ", ex);
        }

        return connection;
    }
}
