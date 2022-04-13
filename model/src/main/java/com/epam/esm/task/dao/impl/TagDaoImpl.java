package com.epam.esm.task.dao.impl;

import com.epam.esm.task.builder.impl.TagBuilder;
import com.epam.esm.task.dao.AbstractDao;
import com.epam.esm.task.dao.EntityQuery;
import com.epam.esm.task.dao.TagDao;
import com.epam.esm.task.dao.mapper.TagMapper;
import com.epam.esm.task.entity.impl.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TagDaoImpl extends AbstractDao<Tag,Long> implements TagDao {

    private TagBuilder builder;

    @Autowired
    public TagDaoImpl(JdbcTemplate jdbcTemplate, TagBuilder builder) {
        super(jdbcTemplate);
        this.builder = builder;
    }

    @Override
    public long create(Tag entity) {
        return executeEntity(entity,EntityQuery.INSERT_TAG);
    }

    @Override
    public List<Tag> read() {
        return jdbcTemplate.query(EntityQuery.SELECT_TAG,new TagMapper(builder));
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update(EntityQuery.DELETE_TAG,id);
    }

    @Override
    public Tag findById(Long id) {
        return jdbcTemplate.queryForObject(EntityQuery.FIND_BY_ID_TAG,new TagMapper(builder),id);
    }

    @Override
    public List<Long> createWithList(List<Tag> tagList) {
        List<Long> idList = new ArrayList<>();
        tagList.forEach(i -> {
            idList.add(create(i));
        });
        return idList;
    }

    @Override
    public Tag findByName(String name) {
        return jdbcTemplate.queryForObject(EntityQuery.FIND_BY_NAME_TAG,new TagMapper(builder),name);
    }

    @Override
    protected long executeEntity(Tag entity, String query) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.
                    prepareStatement(EntityQuery.INSERT_TAG);
            fillPreparedStatement(entity,statement);
            return statement;
        },keyHolder);
        return keyHolder.getKey().longValue();
    }

    @Override
    protected void fillPreparedStatement(Tag entity, PreparedStatement statement) throws SQLException {
        statement.setString(1,entity.getName());
    }

}
