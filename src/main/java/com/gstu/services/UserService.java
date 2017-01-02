package com.gstu.services;

import com.gstu.dao.UserDao;
import com.gstu.executor.Executor;
import com.gstu.models.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {

    private final static Object lock = new Object();

    private final UserDao userDao;

    public UserService() throws SQLException {
        this.userDao = new UserDao(new Executor(ConnectionFactory.getConnection()));
    }

    /**
     * @param login Получение пользователя с заданным login
     * @return Ныйденного user если найдем или null если пользователя с заданным login нет
     * */
    public User getUserByLogin(String login) {
        return userDao.findByLogin(login);
    }

    /**
     * @return Список всех пользователей
     *
     * */
    public List<User> getAllUsers(){
        return userDao.findAll();
    }


    /**
     * @param id Пользователя которого нужно удалить
     * */
    public void deleteUserById(Long id){
        userDao.deleteById(id);
    }

    /**
     * @param user Пользователь у которого необоходимо проверить пароль
     * @param password Пароль который ввел пользовае
     * */
    public boolean checkUserPassword(User user, String password) {
        return user.getPassword().equals(password);
    }

    /**
     * @param user Пользователя которого нужно добавить в БД
     * */
    public boolean addUser(User user) {
        synchronized (lock) {
            // TODO check in login don't repeat
            userDao.insertUser(user);
        }
        return false;
    }
}