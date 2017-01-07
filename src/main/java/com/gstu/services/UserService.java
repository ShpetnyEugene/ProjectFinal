package com.gstu.services;

import com.gstu.models.User;

import java.util.List;

public interface UserService {
    /**
     * Find user by login.
     * Find user in database if user not found return null.
     *
     * @param login Users who need to get
     * @return if the user find or null if the user with the specified login no
     */
    User getUserByLogin(String login);

    /**
     * Find all users
     * Find users in database if users not found returns null
     *
     * @return a list of users
     */
    List<User> getAllUsers();

    /**
     * Delete user by id
     *
     * @param id - id of the user you want to remove
     */
    void deleteUserById(Long id);

    /**
     * This method for adding a new user to the database
     *
     * @param user -  User you want to add to the database
     * @return false if  registration is not possible, and true if user added to database
     */
    boolean addUser(User user);



    boolean checkUserPassword(User user, String password);

    /**
     * The method of finding the user for a given login
     *
     * @param login user that you want to find in the database
     * @return true if the user with the login is found, false otherwise
     */
    boolean checkUserByLogin(String login);

    /**
     * Methods for the user's location with a given identification number
     *
     * @param identificationNumber - parameter user that you want to find in the database
     * @return true if the user with the login is found, false otherwise
     */
    boolean checkUserByIdentificationNumber(String identificationNumber);
}
