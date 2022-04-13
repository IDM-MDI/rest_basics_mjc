package com.epam.esm.task.service.impl;

import com.epam.esm.task.dao.impl.TagDaoImpl;
import com.epam.esm.task.dto.impl.TagDto;
import com.epam.esm.task.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@Service
@EnableTransactionManagement(proxyTargetClass = true)
public class TagService implements CustomService<TagDto,Long> {

    private final TagDaoImpl dao;

    @Autowired
    public TagService(TagDaoImpl dao) {
        this.dao = dao;
    }

    @Override
    public void save(TagDto dto) {
        dao.create(TagDto.toEntity(dto));
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public void update(TagDto dto, Long id) {}

    @Override
    public List<TagDto> findAll() {
        return TagDto.toDtoList(dao.read());
    }

    @Override
    public TagDto findById(Long id) {
        return TagDto.toDto(dao.findById(id));
    }
}
