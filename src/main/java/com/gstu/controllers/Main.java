package com.gstu.controllers;

import com.gstu.services.TrainServices;

public class Main {
    public static void main(String[] args) {

        TrainServices trainServices = new TrainServices();
        trainServices.decrementNumberFreePlaces(1);
    }
}
