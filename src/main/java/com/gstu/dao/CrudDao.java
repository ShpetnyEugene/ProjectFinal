package com.gstu.dao;

import java.sql.SQLException;
import java.util.List;

public interface CrudDao<T, TKey> {
    T findById(TKey id) throws SQLException;
    List<T> findAll();
    T update(T entity);
    T save(T entity);
    void deleteById(TKey key);
}
