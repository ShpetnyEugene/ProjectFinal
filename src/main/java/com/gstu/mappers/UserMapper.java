package com.gstu.mappers;


import com.gstu.executor.Mapper;
import com.gstu.models.Role;
import com.gstu.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements Mapper<User>{

    //private static Logger log = Logger.getLogger(UserDao.class);

    private static final String ID_USER = "idUSer";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String IDENTIFICATION_NUMBER = "identificationNumber";
    private static final String PATRONYMIC = "patronymic";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String BIRTHDAY = "birthDay";
    private static final String ROLE = "role";


    @Override
    public User processLine(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setIdUser(resultSet.getLong(ID_USER));
        user.setFirstName(resultSet.getString(FIRST_NAME));
        user.setLastName(resultSet.getString(LAST_NAME));
        user.setPatronymic(resultSet.getString(PATRONYMIC));
        user.setBirthDay(resultSet.getDate(BIRTHDAY));
        user.setIdentificationNumber(resultSet.getString(IDENTIFICATION_NUMBER));
        user.setLogin(resultSet.getString(LOGIN));
        user.setPassword(resultSet.getString(PASSWORD));
        user.setRole(Role.roleFromId(resultSet.getInt(ROLE)));
        return user;
    }
}
