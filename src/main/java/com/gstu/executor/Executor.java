package com.gstu.executor;

import com.gstu.dao.DataAccessException;
import com.gstu.models.Role;
import org.apache.log4j.Logger;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class Executor {

    private final Connection connection;

    private final static Logger log = Logger.getLogger(Executor.class);

    public Executor(Connection connection) {
        this.connection = connection;
    }

    public int execUpdate(String query, Object... params) {
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            setParams(stmt, params);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            log.error(e);
            throw new DataAccessException(e);
        }
    }


    public <T> T selectOne(String query, Mapper<T> mapper, Object... params) {

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            setParams(stmt, params);

            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                return mapper.processLine(resultSet);
            } else {
                return null;
            }

        } catch (SQLException e) {
            log.error(e);
            throw new DataAccessException(e);
        }
    }

    public <T> List<T> selectList(String query, Mapper<T> mapper, Object... params) {

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            setParams(stmt, params);
            List<T> list = new ArrayList<>();
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                list.add(mapper.processLine(resultSet));
            }

            return list;
        } catch (SQLException e) {
            throw new DataAccessException(e);
        }
    }

    public <T> T execQuery(String query, ResultHandler<T> handler) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute(query);
        ResultSet result = stmt.getResultSet();
        T value = handler.handle(result);
        result.close();
        stmt.close();

        return value;
    }

    private void setParams(PreparedStatement stmt, Object[] params) {
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                try {
                    setParam(stmt, i + 1, params[i]);
                } catch (SQLException e) {
                    e.printStackTrace();
                    log.error(e);
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
    }


    private void setParam(PreparedStatement stmt, int i, Object object) throws SQLException {
        Class c = object.getClass();
        System.out.println(object);
        System.out.println(object instanceof Date);
        if (object instanceof String) {
            stmt.setString(i, (String) object);
        } else if (object instanceof Integer) {
            stmt.setInt(i, (Integer) object);
        }else if (object instanceof Long) {
                stmt.setLong(i, (Long) object);
        }else if (object instanceof Date){
            stmt.setDate(i, (Date) object);
        }else if (object instanceof Role){
            stmt.setInt(i,2);
        }
        else {
            throw new IllegalArgumentException();
        }
    }
}