package com.epam.esm.task.dao.mapper;

import com.epam.esm.task.builder.impl.GiftCertificateBuilder;
import com.epam.esm.task.dao.ColumnName;
import com.epam.esm.task.entity.impl.GiftCertificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
public class GiftCertificateMapper implements RowMapper<GiftCertificate> {

    private final GiftCertificateBuilder builder;

    public GiftCertificateMapper(GiftCertificateBuilder builder) {
        this.builder = builder;
    }

    @Override
    public GiftCertificate mapRow(ResultSet rs, int rowNum) throws SQLException {
        return builder.setName(rs.getString(ColumnName.NAME)).
                setDescription(rs.getString(ColumnName.DESCRIPTION)).
                setPrice(rs.getBigDecimal(ColumnName.PRICE)).
                setDuration(rs.getInt(ColumnName.DURATION)).
                setCreate_date(LocalDateTime.ofInstant(
                        rs.getDate(ColumnName.CREATE_DATE).toInstant(),
                        ZoneId.systemDefault())).
                setUpdate_date(LocalDateTime.ofInstant(
                        rs.getDate(ColumnName.LAST_UPDATE_DATE).toInstant(),
                                ZoneId.systemDefault())).
                getResult();
    }
}
