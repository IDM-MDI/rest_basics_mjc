package com.epam.esm.task.builder.impl;

import com.epam.esm.task.entity.impl.GiftCertificate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class GiftCertificateBuilderTest {

    private final GiftCertificate expected = new GiftCertificate(1,"test","test",new BigDecimal(55),10,
            LocalDateTime.parse("2018-08-29T06:12:15.156"),LocalDateTime.parse("2018-08-29T06:12:15.156"));

    @Test
    public void getResult() {
        GiftCertificateBuilder builder = new GiftCertificateBuilder();
        GiftCertificate actual = builder.setId(1).setName("test").setDescription("test").
                setPrice(new BigDecimal(55)).setDuration(10).
                setCreate_date(LocalDateTime.parse("2018-08-29T06:12:15.156")).
                setUpdate_date(LocalDateTime.parse("2018-08-29T06:12:15.156")).
                getResult();
        Assertions.assertEquals(actual,expected);
    }
}