package com.epam.esm.task.dao;

import java.util.List;

public interface CrdDao<T,K> {
    long create(T entity);
    List<T> read();
    void delete(K id);
}
