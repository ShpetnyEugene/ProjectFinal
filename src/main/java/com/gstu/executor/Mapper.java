package com.gstu.executor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Shpetny Eugene
 * @version 1.0
 * */
public interface Mapper<T> {
    T processLine(ResultSet resultSet) throws SQLException;
}
