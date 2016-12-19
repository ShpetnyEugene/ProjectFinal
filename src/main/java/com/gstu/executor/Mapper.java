package com.gstu.executor;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Mapper<T> {
    T processLine(ResultSet resultSet) throws SQLException;
}
