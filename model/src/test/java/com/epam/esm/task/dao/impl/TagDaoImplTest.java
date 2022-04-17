package com.epam.esm.task.dao.impl;

import com.epam.esm.task.config.SpringJdbcTestConfig;
import com.epam.esm.task.entity.impl.Tag;
import com.epam.esm.task.exception.DaoException;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration(classes = SpringJdbcTestConfig.class)
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
class TagDaoImplTest {

    private Tag tag1;
    private Tag tag2;
    private Tag tag3;


    @Before
    public void init(){
        tag1 = new Tag(1,"tag1");
    }

    @Autowired
    private TagDaoImpl dao;

    @Test
    void create() {
    }

    @Test
    void read() {
        List<Tag> list = null;
        try {
            list = dao.read();
        } catch (DaoException e) {
            e.printStackTrace();
        }
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