package com.epam.esm.task.service.impl;

import com.epam.esm.task.dao.impl.GiftCertificateDaoImpl;
import com.epam.esm.task.dto.impl.GiftCertificateDto;
import com.epam.esm.task.entity.impl.GiftCertificate;
import com.epam.esm.task.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@Service
@EnableTransactionManagement(proxyTargetClass = true)
public class GiftCertificateService implements CustomService<GiftCertificateDto,Long> {

    private final GiftCertificateDaoImpl dao;

    @Autowired
    public GiftCertificateService(GiftCertificateDaoImpl dao) {
        this.dao = dao;
    }

    @Override
    public void save(GiftCertificateDto dto) {
        dao.create(GiftCertificateDto.toEntity(dto));
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public void update(GiftCertificateDto dto, Long id) {
        dao.update(GiftCertificateDto.toEntity(dto),id);
    }

    @Override
    public List<GiftCertificateDto> findAll() {
        return GiftCertificateDto.toDtoList(dao.read());
    }

    @Override
    public GiftCertificateDto findById(Long id) {
        return GiftCertificateDto.toDto(dao.findById(id));
    }

}