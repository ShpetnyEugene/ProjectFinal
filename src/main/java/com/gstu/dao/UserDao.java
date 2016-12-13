package com.gstu.dao;

import com.gstu.models.User;
import com.gstu.services.DataBaseConnection;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements CrudDao<User, Long> {

    private static Logger log = Logger.getLogger(UserDao.class);
    private static String ID_USER = "idUSer";
    private static String FIST_NAME = "firstName";
    private static String LAST_NAME = "lastName";
    private static String PASSPORT_SERIAL = "passportSerial";
    private static String PATRONYMIC = "patronymic";
    private static String LOGIN = "login";
    private static String PASSWORD = "password";
    private static String AGE = "age";
    private static String ROLE = "role";



    public void insertUser(User user) {
        DataBaseConnection dataBaseConnection = null;
        try {
            dataBaseConnection = DataBaseConnection.getInstance();
        } catch (SQLException e) {
            log.error(e);
            // FIXME: 11.12.2016 Пустая строка !!!!
            throw new DataAccessException("", e);
        }

        Connection connection = dataBaseConnection.getConnection();
            // TODO Добавление нового пользователя в базу
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO user(firstName,lastName,age,patrnymic,passportSerial,login,password,role) VALUES(?,?,?,?,?,?,?,?,?) ")) {
            statement.setString(2,user.getFirsName());
            statement.setString(3,user.getLastName());
            statement.setInt(4,user.getAge());
            statement.setString(5,user.getPatronymic());
            statement.setString(6,user.getPassportSerial());
            statement.setString(7,user.getLogin());
            statement.setString(8,user.getPassword());
            statement.setInt(9 ,user.getRole());

        } catch (SQLException e) {
            log.error(e);
            // TODO исправить значение ошибки
            throw new DataAccessException("User with id not found " , e);
        }
    }

    @Override
    public User findById(Long id) {

        DataBaseConnection dataBaseConnection = null;
        User user = null;
        try {
            dataBaseConnection = DataBaseConnection.getInstance();
        } catch (SQLException e) {
            log.error(e);
            // FIXME: 11.12.2016 Пустая строка !!!!
            throw new DataAccessException("", e);
        }

        Connection connection = dataBaseConnection.getConnection();

        try (PreparedStatement statement = connection.prepareStatement("select * from user WHERE idUser = ?")) {


            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            user = new User(resultSet.getInt(ID_USER),
                    resultSet.getString(FIST_NAME),
                    resultSet.getString(LAST_NAME),
                    resultSet.getString(PATRONYMIC),
                    resultSet.getInt(AGE),
                    resultSet.getString(PASSPORT_SERIAL),
                    resultSet.getString(LOGIN),
                    resultSet.getString(PASSWORD),
                    resultSet.getInt(ROLE));

        } catch (SQLException e) {
            log.error(e);
            throw new DataAccessException("User with id not found " + id, e);
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();

        DataBaseConnection dataBaseConnection = null;
        try {
            dataBaseConnection = DataBaseConnection.getInstance();
        } catch (SQLException e) {
            log.error(e);
            throw new DataAccessException("", e);
        }

        Connection connection = dataBaseConnection.getConnection();

        try (PreparedStatement statement = connection.prepareStatement("select * from user")) {

            ResultSet resultSet = statement.executeQuery();


            while (resultSet.next()) {
                users.add(new User(resultSet.getInt(ID_USER),
                        resultSet.getString(FIST_NAME),
                        resultSet.getString(LAST_NAME),
                        resultSet.getString(PATRONYMIC),
                        resultSet.getInt(AGE),
                        resultSet.getString(PASSPORT_SERIAL),
                        resultSet.getString(LOGIN),
                        resultSet.getString(PASSWORD),
                        resultSet.getInt(ROLE))
                );
            }
        } catch (SQLException e) {
            log.error(e);
            // FIXME: 11.12.2016 Возмоджно исправить запись
            throw new DataAccessException("Users have found", e);
        }
        return users;

    }

    @Override
    public User update(User entity) {
        return null;
    }

    @Override
    public User save(User entity) {
        return null;
    }

    @Override
    public User deleteById(Long aLong) {
        DataBaseConnection dataBaseConnection = null;
        try {
            dataBaseConnection = DataBaseConnection.getInstance();
        } catch (SQLException e) {
            log.error(e);
            // FIXME: 11.12.2016
            throw new DataAccessException("", e);
        }
        Connection connection = dataBaseConnection.getConnection();
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM user WHERE idUser= ?")) {
        } catch (SQLException e) {
            log.error(e);
            throw new DataAccessException("Train with id not found" + ID_USER, e);
        }
        return null;
    }

}
