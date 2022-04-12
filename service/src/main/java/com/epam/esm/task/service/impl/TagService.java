package com.epam.esm.task.service.impl;

import com.epam.esm.task.dao.impl.TagDao;
import com.epam.esm.task.entity.impl.Tag;
import com.epam.esm.task.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@Service
@EnableTransactionManagement(proxyTargetClass = true)
public class TagService implements CustomService<Tag,Long> {

    private final TagDao dao;

    @Autowired
    public TagService(TagDao dao) {
        this.dao = dao;
    }

    @Override
    public void save(Tag entity) {
        dao.create(entity);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public void update(Tag entity) {}

    @Override
    public List<Tag> findAll() {
        return dao.read();
    }

    @Override
    public Tag findById(Long id) {
        return dao.findById(id);
    }
}
