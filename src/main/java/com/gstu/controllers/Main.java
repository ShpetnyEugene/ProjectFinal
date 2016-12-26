package com.gstu.controllers;

import com.gstu.dao.TrainDao;
import com.gstu.executor.Executor;
import com.gstu.models.Train;
import com.gstu.services.DataBaseConnection;
import com.gstu.services.RecordsTrainService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws SQLException {
/*
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/railwaydb","root","5674");

        UserDao userDao = new UserDao(new Executor(connection));
        System.out.println(userDao.findByLogin("shpetny.eugene@gmail.com"));


        PreparedStatement statement = connection.prepareStatement("INSERT INTO train (name,numberFreePlaces) VALUES(?,?)");

        statement.setString(1, "KS 323");
        statement.setInt(2, 20);

        statement.executeUpdate();
        statement.close();
     *   connection.close();*/





        TrainDao trainDao = new TrainDao(new Executor(DataBaseConnection.getInstance().getConnection()));

        List<Train> trains = new ArrayList<>();
        trains = trainDao.findAll();

        for (Train trai: trains) {
            System.out.println(trai);
        }


        RecordsTrainService recordsTrainService = new RecordsTrainService();
        recordsTrainService.DeleteTrainById(Long.parseLong("27"));



        System.out.println("--------------------------------");
        trains = trainDao.findAll();

        for (Train trai: trains) {
            System.out.println(trai);
        }


        //trainDao.deleteById(1L);
    }
}
