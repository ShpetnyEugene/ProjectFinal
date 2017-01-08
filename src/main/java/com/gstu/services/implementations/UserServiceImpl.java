package com.gstu.services.implementations;

import com.gstu.dao.UserDao;
import com.gstu.executor.Executor;
import com.gstu.models.User;
import com.gstu.services.ConnectionFactory;
import com.gstu.services.UserService;

import java.util.List;

/**
 * @author Shpetny Eugene
 * @version 1.0
 */
public class UserServiceImpl implements UserService {

    // Variable on which is synchronized
    private final static Object lock = new Object();

    private final UserDao userDao;

    UserServiceImpl() {
        this.userDao = new UserDao(new Executor(ConnectionFactory.getConnection()));
    }

    /**
     * Find user by login.
     * Find user in database if user not found return null.
     *
     * @param login Users who need to get
     * @return if the user find or null if the user with the specified login no
     */
    public User getUserByLogin(String login) {
        return userDao.findByLogin(login);
    }

    /**
     * Find all users
     * Find users in database if users not found returns null
     *
     * @return a list of users
     */
    public List<User> getAllUsers() {
        return userDao.findAll();
    }


    /**
     * Delete user by id
     *
     * @param id - id of the user you want to remove
     */
    public void deleteUserById(Long id) {
        userDao.deleteById(id);
    }

    /**
     * The method checked the password for this user
     *
     * @param user     - Users who need to verify your password
     * @param password - The password entered by the user
     */
    public boolean checkUserPassword(User user, String password) {
        return user.getPassword().equals(password);
    }

    /**
     * This method for adding a new user to the database
     *
     * @param user -  User you want to add to the database
     * @return false if  registration is not possible, and true if user added to database
     */
    public boolean addUser(User user) {
        synchronized (lock) {
            if (checkUserByIdentificationNumber(user.getIdentificationNumber())
                    || checkUserByLogin(user.getLogin())) {
                return false;
            } else {
                userDao.insertUser(user);
                return true;
            }
        }
    }

    /**
     * The method of finding the user for a given login
     *
     * @param login user that you want to find in the database
     * @return true if the user with the login is found, false otherwise
     */
    public boolean checkUserByLogin(String login) {
        UserDao userDao = new UserDao(new Executor(ConnectionFactory.getConnection()));
        return userDao.findByLogin(login) != null;
    }

    /**
     * Methods for the user's location with a given identification number
     *
     * @param identificationNumber - parameter user that you want to find in the database
     * @return true if the user with the login is found, false otherwise
     */
    public boolean checkUserByIdentificationNumber(String identificationNumber) {
        UserDao userDao = new UserDao(new Executor(ConnectionFactory.getConnection()));
        return userDao.findByIdentificationNumber(identificationNumber) != null;
    }
}