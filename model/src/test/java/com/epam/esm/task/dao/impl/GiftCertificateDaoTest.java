package com.epam.esm.task.dao.impl;

import com.epam.esm.task.config.SpringJdbcTestConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = SpringJdbcTestConfig.class)
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
class GiftCertificateDaoTest {

    @Test
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