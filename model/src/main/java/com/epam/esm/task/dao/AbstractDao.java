package com.epam.esm.task.dao;

import com.epam.esm.task.entity.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public abstract class AbstractDao<T extends Entity, K> implements CrudDao<T,K>{

    protected final JdbcTemplate jdbcTemplate;

    public AbstractDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public abstract T findById(K id);
}
