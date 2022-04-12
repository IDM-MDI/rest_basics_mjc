package com.epam.esm.task.dao.impl;

import com.epam.esm.task.config.SpringJdbcTestConfig;
import com.epam.esm.task.entity.impl.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = SpringJdbcTestConfig.class)
@ActiveProfiles("test")
//@ExtendWith(SpringExtension.class)
class TagDaoTest {

    @Autowired
    private TagDao dao;

    @Test
    void create() {
    }

    @Test
    void read() {
        List<Tag> list = dao.read();
        System.out.println(list);
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