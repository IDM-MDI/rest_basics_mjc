package com.epam.esm.task.dao.impl;

import com.epam.esm.task.builder.impl.TagBuilder;
import com.epam.esm.task.dao.AbstractDao;
import com.epam.esm.task.dao.ColumnName;
import com.epam.esm.task.dao.query.EntityQuery;
import com.epam.esm.task.dao.TagDao;
import com.epam.esm.task.dao.mapper.TagMapper;
import com.epam.esm.task.entity.impl.Tag;
import com.epam.esm.task.exception.DaoException;
import com.epam.esm.task.exception.DaoExceptionCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class TagDaoImpl extends AbstractDao<Tag,Long> implements TagDao {

    private final TagBuilder builder;

    @Autowired
    public TagDaoImpl(JdbcTemplate jdbcTemplate, TagBuilder builder) {
        super(jdbcTemplate);
        this.builder = builder;
    }

    @Override
    public long create(Tag entity) throws DaoException {
        try {
            return executeEntity(entity,EntityQuery.INSERT_TAG);
        } catch (DataAccessException e) {
            throw new DaoException(DaoExceptionCode.DAO_SAVE_ERROR.toString(), e);
        }
    }

    @Override
    public List<Tag> read() throws DaoException {
        try {
            return jdbcTemplate.query(EntityQuery.SELECT_TAG,new TagMapper(builder));
        } catch (DataAccessException e) {
            throw new DaoException(DaoExceptionCode.DAO_NOTHING_FIND_EXCEPTION.toString(), e);
        }
    }

    @Override
    public void delete(Long id) throws DaoException {
        try {
            jdbcTemplate.update(EntityQuery.DELETE_TAG,id);
        } catch (DataAccessException e) {
            throw new DaoException(DaoExceptionCode.DAO_NOTHING_FIND_BY_ID.toString(), e);
        }
    }

    @Override
    public Tag findById(Long id) throws DaoException {
        try {
            return jdbcTemplate.queryForObject(EntityQuery.FIND_BY_ID_TAG,new TagMapper(builder),id);
        } catch (DataAccessException e) {
            throw new DaoException(DaoExceptionCode.DAO_NOTHING_FIND_BY_ID.toString(), e);
        }
    }

    @Override
    public List<Long> createWithList(List<Tag> tagList) throws DaoException {
        try {
            List<Long> idList = new ArrayList<>();
            tagList.forEach(i -> {
                try {idList.add(create(i));}
                catch (DaoException ignored) {}
            });
            return idList;
        } catch (DataAccessException e) {
            throw new DaoException(DaoExceptionCode.DAO_SAVE_ERROR.toString(), e);
        }
    }

    @Override
    public Tag findByName(String name) throws DaoException {
        try {
            return jdbcTemplate.queryForObject(EntityQuery.FIND_BY_NAME_TAG,new TagMapper(builder),name);
        } catch (DataAccessException e) {
            throw new DaoException(DaoExceptionCode.DAO_NOTHING_FIND_BY_ID.toString(), e);
        }
    }

    @Override
    protected long executeEntity(Tag entity, String query) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.
                    prepareStatement(EntityQuery.INSERT_TAG, Statement.RETURN_GENERATED_KEYS);
            fillPreparedStatement(entity,statement);
            return statement;
        },keyHolder);
        return Objects.requireNonNull(keyHolder.getKey()).longValue();
    }

    @Override
    protected void fillPreparedStatement(Tag entity, PreparedStatement statement) throws SQLException {
        statement.setString(1,entity.getName());
    }

}
