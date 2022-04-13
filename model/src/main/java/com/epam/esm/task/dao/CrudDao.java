package com.epam.esm.task.dao;

public interface CrudDao<T,K> extends CrdDao<T,K>{
    void update(T entity, K id);
}
