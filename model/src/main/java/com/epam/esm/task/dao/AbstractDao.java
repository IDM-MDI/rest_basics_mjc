package com.epam.esm.task.dao;

import com.epam.esm.task.entity.Entity;
import com.epam.esm.task.exception.DaoException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public abstract class AbstractDao<T extends Entity, K>{

    protected final JdbcTemplate jdbcTemplate;

    public AbstractDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public abstract T findById(K id) throws DaoException;
    protected abstract void fillPreparedStatement(T entity,PreparedStatement statement) throws SQLException;
    protected abstract long executeEntity(T entity,String query) throws DaoException;
}
