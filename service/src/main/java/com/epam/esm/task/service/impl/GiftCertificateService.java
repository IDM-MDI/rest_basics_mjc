package com.epam.esm.task.service.impl;

import com.epam.esm.task.dao.impl.GiftCertificateDaoImpl;
import com.epam.esm.task.entity.impl.GiftCertificate;
import com.epam.esm.task.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@Service
@EnableTransactionManagement(proxyTargetClass = true)
public class GiftCertificateService implements CustomService<GiftCertificate,Long> {

    private final GiftCertificateDaoImpl dao;

    @Autowired
    public GiftCertificateService(GiftCertificateDaoImpl dao) {
        this.dao = dao;
    }

    @Override
    public void save(GiftCertificate entity) {
        dao.create(entity);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public void update(GiftCertificate entity) {
        dao.update(entity);
    }

    @Override
    public List<GiftCertificate> findAll() {
        return dao.read();
    }

    @Override
    public GiftCertificate findById(Long id) {
        return dao.findById(id);
    }

}