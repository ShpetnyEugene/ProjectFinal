package com.gstu.dao;

import com.gstu.executor.Executor;
import com.gstu.mappers.UserMapper;
import com.gstu.models.User;
import org.apache.log4j.Logger;

import java.util.List;

public class UserDao implements CrudDao<User, Long> {


    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM user WHERE idUser = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM user";
    private static final String DELETE_BY_ID_QUERY = "DELETE FROM user WHERE idUser= ?";
    private static final String SELECT_BY_LOGIN_QUERY = "SELECT * FROM user WHERE login = ?";
    private static final String INSERT_NEW_USER = "INSERT INTO user (firstName,lastName,age,patronymic,passportSerial,login,password,role) VALUES(?,?,?,?,?,?,?,?) ";
    private static final String SELECT_BY_PASSPORT_SERIAL_QUERY = "SELECT * FROM user WHERE identificationNumber = ?";



    private com.gstu.executor.Executor executor;
    private static Logger log = Logger.getLogger(UserDao.class);

    public UserDao (Executor executor){
        this.executor = executor;
    }


    public int insertUser(User user) {
        return executor.execUpdate(INSERT_NEW_USER,user.getFirstName(),user.getLastName(),user.getAge(),user.getPatronymic(),
                user.getIdentificationNumber(),user.getLogin(),user.getPassword(),user.getRole());
    }

    public User findByLogin(String login){
        return executor.selectOne(SELECT_BY_LOGIN_QUERY,new UserMapper(),login);
    }

    public User findByIdentificationNumber (String identificationNumber){
        return executor.selectOne(SELECT_BY_PASSPORT_SERIAL_QUERY,new UserMapper(),identificationNumber);
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
        throw new UnsupportedOperationException();
    }

    @Override
    public User save(User entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public User deleteById(Long aLong) {
        executor.execUpdate(DELETE_BY_ID_QUERY,  aLong);
        return null;
    }
}