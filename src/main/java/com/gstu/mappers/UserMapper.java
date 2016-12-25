package com.gstu.mappers;


import com.gstu.executor.Mapper;
import com.gstu.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements Mapper<User>{

    //private static Logger log = Logger.getLogger(UserDao.class);

    private static String ID_USER = "idUSer";
    private static String FIRST_NAME = "firstName";
    private static String LAST_NAME = "lastName";
    private static String PASSPORT_SERIAL = "passportSerial";
    private static String PATRONYMIC = "patronymic";
    private static String LOGIN = "login";
    private static String PASSWORD = "password";
    private static String AGE = "age";
    private static String ROLE = "role";


    @Override
    public User processLine(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setIdUser(resultSet.getLong(ID_USER));
        user.setFirsName(resultSet.getString(FIRST_NAME));
        user.setLastName(resultSet.getString(LAST_NAME));
        user.setPatronymic(resultSet.getString(PATRONYMIC));
        user.setAge(resultSet.getInt(AGE));
        user.setPassportSerial(resultSet.getString(PASSPORT_SERIAL));
        user.setLogin(resultSet.getString(LOGIN));
        user.setPassword(resultSet.getString(PASSWORD));
        user.setRole(resultSet.getInt(ROLE));
        // TODO Тут писать result.getObject
        return user;
    }
}
