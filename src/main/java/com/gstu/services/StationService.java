package com.gstu.services;

public interface StationService {
    /**
     * Find id station by name.
     * Find name in database if user not found return null.
     *
     * @param name station who need to find
     * @return id with the given name
     */
   long findId(String name);
}
