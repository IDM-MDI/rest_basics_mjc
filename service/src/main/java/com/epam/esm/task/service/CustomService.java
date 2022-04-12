package com.epam.esm.task.service;

import java.util.List;

public interface CustomService<T,K> {
    void save(T entity);
    void delete(K id);
    void update(T entity);
    List<T> findAll();
    T findById(K id);
}
