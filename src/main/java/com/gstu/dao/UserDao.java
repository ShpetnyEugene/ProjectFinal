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

    private static final String INSERT_NEW_USER = "INSERT INTO user (firstName,lastName,birthDay,patronymic,identificationNumber,login,password,role) VALUES(?,?,?,?,?,?,?,?) ";

    private static final String SELECT_BY_PASSPORT_SERIAL_QUERY = "SELECT * FROM user WHERE identificationNumber = ?";


    private com.gstu.executor.Executor executor;
    private static Logger log = Logger.getLogger(UserDao.class);

    public UserDao(Executor executor) {
        this.executor = executor;
    }

    /**
     * Adding a new user to the database
     *
     * @param user - are added to the database
     * @return The value of an int type, which indicates the number of rows processed, or 0 for data definition language statements.
     */
    public int insertUser(User user) {
        return executor.execUpdate(INSERT_NEW_USER, user.getFirstName(), user.getLastName(), user.getBirthDay(), user.getPatronymic(),
                user.getIdentificationNumber(), user.getLogin(), user.getPassword(), user.getRole());
    }

    /**
     * Find user by login.
     * Find user in database if user not found return null.
     *
     * @param login Users who need to find
     * @return User with the given login
     */
    public User findByLogin(String login) {
        return executor.selectOne(SELECT_BY_LOGIN_QUERY, new UserMapper(), login);
    }


    /**
     * Find user by identification Number.
     * Find user in database if user not found return null.
     *
     * @param identificationNumber Users who need to find
     * @return User with the given identificationNumber
     */
    public User findByIdentificationNumber(String identificationNumber) {
        return executor.selectOne(SELECT_BY_PASSPORT_SERIAL_QUERY, new UserMapper(), identificationNumber);
    }

    /**
     * Find user by id.
     * Find user in database if user not found return null.
     *
     * @param id Users who need to find
     * @return User with the given id
     */
    @Override
    public User findById(Long id) {
        return executor.selectOne(SELECT_BY_ID_QUERY, new UserMapper(), id);
    }

    /**
     * Find all users
     * Find users in database if users not found returns null
     *
     * @return a list of users
     */
    @Override
    public List<User> findAll() {
        return executor.selectList(SELECT_ALL_QUERY, new UserMapper());
    }

    /**
     * The method is not supported
     *
     * @throws UnsupportedOperationException, when calling
     */
    @Override
    public User update(User entity) {
        log.error(new UnsupportedOperationException());
        throw new UnsupportedOperationException();
    }

    /**
     * The method is not supported
     *
     * @throws UnsupportedOperationException, when calling
     */
    @Override
    public User save(User entity) {
        log.error(new UnsupportedOperationException());
        throw new UnsupportedOperationException();
    }

    /**
     * Delete user by id
     *
     * @param aLong - id of the user you want to remove
     */
    @Override
    public void deleteById(Long aLong) {
        executor.execUpdate(DELETE_BY_ID_QUERY, aLong);
    }
}