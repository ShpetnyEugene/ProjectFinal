package com.gstu.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Reservation {
    private static final String QUERY  = "select *  FROM train INNER JOIN (station INNER JOIN schedule ON (station.idStation = schedule.stationEnd_idStation1)) ON train.idTrain = schedule.train_idTrain\n" +
            "WHERE (((schedule.order)=?) AND ((schedule.stationEnd_idStation1)=?) AND ((train.numberFreePlaces)<>0) AND ((schedule.departureTime)>?)) and ((schedule.stationStart_idStation)=?);\n";


    public void showTrains(int order,int stationEnd_idStation1, int numberFreePlaces,String departureTime,int stationStart_idStation){
        try(PreparedStatement preparedStatement = ConnectionFactory.getConnection().prepareStatement(QUERY)) {

            ResultSet resultSet = preparedStatement.getResultSet();

            resultSet.getInt("numberFreePlaces");
            resultSet.getString("departureTime");

            System.out.println(resultSet.getInt("numberFreePlaces") + "  " + resultSet.getString("departureTime"));



        } catch (SQLException e) {
            e.printStackTrace();
        } ;

    }


}
