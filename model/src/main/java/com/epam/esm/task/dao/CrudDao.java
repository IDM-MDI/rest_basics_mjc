package com.epam.esm.task.dao;

import com.epam.esm.task.entity.Entity;

import java.util.List;

public interface CrudDao <T extends Entity, K>{
    void create(T entity);
    List<T> read();
    void update(T entity);
    void delete(K id);
}
