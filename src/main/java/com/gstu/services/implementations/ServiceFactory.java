package com.gstu.services.implementations;

import com.gstu.services.TrainService;
import com.gstu.services.UserService;

public class ServiceFactory {

    private ServiceFactory() {

    }

    public static TrainService trainService() {
        return new TrainServiceImpl();
    }

    public static UserService userService() {
//        return new FakeUserService();
        return new UserServiceImpl();
    }
}
