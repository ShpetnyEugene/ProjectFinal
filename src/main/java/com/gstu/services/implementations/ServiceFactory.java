package com.gstu.services.implementations;

import com.gstu.services.TrainService;

public class ServiceFactory {

    private ServiceFactory() {

    }

    public static TrainService trainService() {
        return new TrainServiceImpl();
    }
}
