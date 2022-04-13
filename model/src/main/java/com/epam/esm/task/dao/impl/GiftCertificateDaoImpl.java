package com.epam.esm.task.dao.impl;

import com.epam.esm.task.builder.impl.GiftCertificateBuilder;
import com.epam.esm.task.dao.AbstractDao;
import com.epam.esm.task.dao.EntityQuery;
import com.epam.esm.task.dao.GiftCertificateDao;
import com.epam.esm.task.dao.mapper.GiftCertificateMapper;
import com.epam.esm.task.entity.impl.GiftCertificate;
import com.epam.esm.task.entity.impl.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GiftCertificateDaoImpl extends AbstractDao<GiftCertificate,Long> implements GiftCertificateDao {

    private final GiftCertificateBuilder builder;
    private final TagDaoImpl tagDao;
    private final ManyToManyDaoImpl mtmDao;

    @Autowired
    public GiftCertificateDaoImpl(JdbcTemplate jdbcTemplate,
                                  GiftCertificateBuilder builder,
                                  TagDaoImpl tagDao,
                                  ManyToManyDaoImpl mtmDao) {
        super(jdbcTemplate);
        this.builder = builder;
        this.tagDao = tagDao;
        this.mtmDao = mtmDao;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public long create(GiftCertificate entity) {
        long giftId = executeEntity(entity,EntityQuery.INSERT_GIFT);
        mtmDao.create(giftId,tagDao.createWithList(entity.getTags()));
        return giftId;
    }

    @Transactional
    @Override
    public List<GiftCertificate> read() {
        List<GiftCertificate> gifts = jdbcTemplate.query(EntityQuery.SELECT_GIFT,
                new GiftCertificateMapper(builder));

        gifts.forEach(i -> {
            List<Tag> tagList = new ArrayList<>();
                mtmDao.findByGiftId(i.getId()).forEach(j -> {
                    tagList.add(tagDao.findById(j.getTagId()));
                });
            i.setTags(tagList);
        });

        return gifts;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(GiftCertificate entity, Long id) {
        jdbcTemplate.update(EntityQuery.UPDATE_GIFT,
                entity.getName(),entity.getDescription(),
                entity.getPrice(),entity.getDuration(),
                entity.getCreate_date(),entity.getUpdate_date(),id);
        mtmDao.deleteByGiftId(id);
        mtmDao.create(id,tagDao.createWithList(entity.getTags()));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Long id) {
        jdbcTemplate.update(EntityQuery.DELETE_GIFT,id);
        mtmDao.deleteByGiftId(id);
    }

    @Override
    public GiftCertificate findById(Long id) {
        GiftCertificate result = jdbcTemplate.queryForObject(EntityQuery.FIND_BY_ID_GIFT,
                new GiftCertificateMapper(builder),id);
        List<Tag> tagList = new ArrayList<>();
        mtmDao.findByGiftId(id).forEach(i -> {
            tagList.add(tagDao.findById(i.getTagId()));
        });
        result.setTags(tagList);
        return result;
    }

    @Override
    protected long executeEntity(GiftCertificate entity, String query) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.
                    prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            fillPreparedStatement(entity,statement);
            return statement;
        },keyHolder);
        return keyHolder.getKey().longValue();
    }

    @Override
    protected void fillPreparedStatement(GiftCertificate entity,PreparedStatement statement) throws SQLException {
        statement.setString(1, entity.getName());
        statement.setString(2,entity.getDescription());
        statement.setBigDecimal(3,entity.getPrice());
        statement.setInt(4, entity.getDuration());
        statement.setDate(5,Date.valueOf(entity.getCreate_date().toLocalDate()));
        statement.setDate(6,Date.valueOf(entity.getUpdate_date().toLocalDate()));
    }
}
