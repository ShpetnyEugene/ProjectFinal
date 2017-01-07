package com.gstu.services.implementations;

import com.gstu.dao.TrainDao;
import com.gstu.factories.DaoFactory;
import com.gstu.models.Train;
import com.gstu.services.TrainService;

import java.util.List;

public class TrainServiceImpl implements TrainService {

    private TrainDao trainDao;

    public TrainServiceImpl() {
        this.trainDao = DaoFactory.trainDao();
    }

    /**
     * Delete train by id
     *
     * @param id - id of the train you want to remove
     */
    @Override
    public void DeleteTrainById(long id) {
        trainDao.deleteById(id);
    }

    /**
     * Find all train
     * Find trains in database if users not found returns null, else returns List<Train>
     *
     * @return a list of users
     */
    @Override
    public List<Train> allTrains() {
        return trainDao.findAll();
    }

    /**
     * Find train by id.
     * Find train in database if user not found return null.
     *
     * @param id Trains who need to find
     * @return Train with the given id
     */

    public Train getTrainById(long id) {
        return trainDao.findById(id);
    }

    /**
     * Changes the number of available seats in the database
     *
     * @param id trains which need to change the number of tickets
     */
    @Override
    public void decrementNumberFreePlaces(long id) {
        trainDao.decrementNumberFreePlaces(id);
    }

    /**
     * Adding a new train to the database
     *
     * @param train - are added to the database
     */
    @Override
    public void addTrain(Train train) {
        trainDao.insertTrain(train);
    }
}
