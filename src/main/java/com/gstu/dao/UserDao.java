package com.gstu.dao;

import com.gstu.executor.Executor;
import com.gstu.mappers.UserMapper;
import com.gstu.models.User;
import com.gstu.services.DataBaseConnection;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDao implements CrudDao<User, Long> {


    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM user WHERE idUser = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM user";
    private static final String DELETE_BY_ID_QUERY = "DELETE FROM user WHERE idUser= ?";
    private static final String SELECT_BY_LOGIN_QUERY = "SELECT * FROM user WHERE login = ?";

    private com.gstu.executor.Executor executor;
    private static Logger log = Logger.getLogger(UserDao.class);

    public UserDao (Executor executor){
        this.executor = executor;
    }


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
            statement.setString(2, user.getFirsName());
            statement.setString(3, user.getLastName());
            statement.setInt(4, user.getAge());
            statement.setString(5, user.getPatronymic());
            statement.setString(6, user.getPassportSerial());
            statement.setString(7, user.getLogin());
            statement.setString(8, user.getPassword());
            statement.setInt(9, user.getRole());

        } catch (SQLException e) {
            log.error(e);
            // TODO исправить значение ошибки
            throw new DataAccessException("User with id not found ", e);
        }
    }

    public User findByLogin(String login){
        return executor.selectOne(SELECT_BY_LOGIN_QUERY,new UserMapper(),login);
    }

    @Override
    public User findById(Long id) {
        return executor.selectOne(SELECT_BY_ID_QUERY, new UserMapper(), id);
    }

    @Override
    public List<User> findAll() {
        return executor.selectList(SELECT_ALL_QUERY, new UserMapper());
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
        return executor.selectOne(DELETE_BY_ID_QUERY, new UserMapper(), aLong);
    }
}