package com.gstu.services;

import com.gstu.models.Train;

import java.util.List;

public interface TrainService {

    /**
     * Delete train by id
     *
     * @param id - id of the train you want to remove
     */
    void DeleteTrainById(long id);


    /**
     * Find all train
     * Find trains in database if users not found returns null, else returns List<Train>
     *
     * @return a list of users
     */
    List<Train> allTrains();

    /**
     * Find train by id.
     * Find train in database if user not found return null.
     *
     * @param id Trains who need to find
     * @return Train with the given id
     */
    Train getTrainById(long id);

    /**
     * Changes the number of available seats in the database
     *
     * @param id trains which need to change the number of tickets
     */
    void decrementNumberFreePlaces(long id);

    /**
     * Adding a new train to the database
     *
     * @param train - are added to the database
     */
    void addTrain(Train train);
}
