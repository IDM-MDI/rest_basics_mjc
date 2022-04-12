package com.epam.esm.task.dao;

import com.epam.esm.task.entity.Entity;

import java.util.List;

public interface CrudDao<T,K> extends CrdDao<T,K>{
    void update(T entity);
}
