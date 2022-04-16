package com.epam.esm.task.dao.impl;

import com.epam.esm.task.config.SpringJdbcTestConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = SpringJdbcTestConfig.class)
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@RunWith(SpringJUnit4ClassRunner.class)
class GiftCertificateDaoImplTest {

    @Test
    @Transactional
    void create() {

    }

    @Test
    void read() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void findById() {
    }
}