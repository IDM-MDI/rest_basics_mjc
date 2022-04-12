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
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GiftCertificateDaoImpl extends AbstractDao<GiftCertificate,Long> implements GiftCertificateDao {

    private final GiftCertificateBuilder builder;
    private final TagDaoImpl tagDao;
    private final ManyToManyDaoImpl mtmDao;

    @Autowired
    public GiftCertificateDaoImpl(JdbcTemplate jdbcTemplate, GiftCertificateBuilder builder, TagDaoImpl tagDao, ManyToManyDaoImpl mtmDao) {
        super(jdbcTemplate);
        this.builder = builder;
        this.tagDao = tagDao;
        this.mtmDao = mtmDao;
    }

    @Transactional
    @Override
    public void create(GiftCertificate entity) {
        jdbcTemplate.update(EntityQuery.INSERT_GIFT,
                entity.getName(),entity.getDescription(),
                entity.getPrice(),entity.getDuration(),
                entity.getCreate_date(),entity.getUpdate_date());
        mtmDao.create(entity.getId(),entity.getTagList());
        tagDao.createWithList(entity.getTagList());
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
    public void update(GiftCertificate entity) {
        jdbcTemplate.update(EntityQuery.UPDATE_GIFT, entity.getId());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Long id) {
        jdbcTemplate.update(EntityQuery.DELETE_GIFT,id);
    }

    @Override
    public GiftCertificate findById(Long id) {
        return jdbcTemplate.queryForObject(EntityQuery.FIND_BY_ID_GIFT,new GiftCertificateMapper(builder),id);
    }

}
