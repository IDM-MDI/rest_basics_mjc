package com.epam.esm.task.dao.impl;

import com.epam.esm.task.builder.impl.TagBuilder;
import com.epam.esm.task.dao.AbstractDao;
import com.epam.esm.task.dao.EntityQuery;
import com.epam.esm.task.dao.TagDao;
import com.epam.esm.task.dao.mapper.TagMapper;
import com.epam.esm.task.entity.impl.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
    public void create(Tag entity) {
        jdbcTemplate.update(EntityQuery.INSERT_TAG,entity.getName());
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
    public void createWithList(List<Tag> tagList) {
        tagList.forEach(this::create);
    }
}
