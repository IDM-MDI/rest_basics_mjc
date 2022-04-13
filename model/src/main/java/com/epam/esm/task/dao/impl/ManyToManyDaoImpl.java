package com.epam.esm.task.dao.impl;

import com.epam.esm.task.dao.AbstractDao;
import com.epam.esm.task.dao.EntityQuery;
import com.epam.esm.task.dao.ManyToManyDao;
import com.epam.esm.task.dao.mapper.ManyToManyMapper;
import com.epam.esm.task.entity.impl.ManyToMany;
import com.epam.esm.task.entity.impl.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ManyToManyDaoImpl extends AbstractDao<ManyToMany,Long> implements ManyToManyDao {

    @Autowired
    public ManyToManyDaoImpl(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public ManyToMany findById(Long id) {
        return jdbcTemplate.queryForObject(EntityQuery.SELECT_MTM_BY_ID, new ManyToManyMapper(),id);
    }

    @Override
    public List<ManyToMany> findByGiftId(long id) {
        return jdbcTemplate.query(EntityQuery.SELECT_BY_GIFT_ID_MTM,new ManyToManyMapper(),id);
    }

    @Override
    public List<ManyToMany> findByTagId(long id) {
        return jdbcTemplate.query(EntityQuery.SELECT_BY_TAG_ID_MTM,new ManyToManyMapper(),id);
    }

    @Override
    public void create(long giftId, List<Long> tagIdList) {
        tagIdList.forEach((i)->{
            jdbcTemplate.update(EntityQuery.INSERT_MTM,giftId,i);
        });
    }

    @Override
    public void update(long giftId, List<Tag> tagList) {
        tagList.forEach((i)->{
            jdbcTemplate.update(EntityQuery.UPDATE_MTM_BY_GIFT_ID,giftId,i.getId());
        });
    }

    @Override
    public void deleteByGiftId(long id) {
        jdbcTemplate.update(EntityQuery.DELETE_BY_GIFT_ID_MTM,id);
    }

    @Override
    public void deleteByTagId(long id) {
        jdbcTemplate.update(EntityQuery.DELETE_BY_TAG_ID_MTM,id);
    }

    @Override
    protected void fillPreparedStatement(ManyToMany entity, PreparedStatement statement) throws SQLException {

    }
}
