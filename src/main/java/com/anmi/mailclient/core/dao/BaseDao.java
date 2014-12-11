package com.anmi.mailclient.core.dao;

import java.util.List;

public interface BaseDao<T> {
    T get(Long id);
    void add(T entity);
    List<T> getAll();
    void deleteById(Long Id);
}
