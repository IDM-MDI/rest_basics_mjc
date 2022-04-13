package com.epam.esm.task.service;

import java.util.List;

public interface CustomService<T,K> {
    void save(T dto);
    void delete(K id);
    void update(T dto, K id);
    List<T> findAll();
    T findById(K id);
}
