package com.epam.esm.task.dto.impl;

import com.epam.esm.task.dto.Dto;
import com.epam.esm.task.entity.impl.GiftCertificate;
import jakarta.validation.constraints.Min;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class GiftCertificateDto extends Dto {
    private String description;
    private BigDecimal price;
    private int duration;

    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private String create_date;

    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private String update_date;

    private List<TagDto> tags;

    public GiftCertificateDto(long id,
                              String name, String description,
                              BigDecimal price, int duration,
                              String create_date, String update_date, List<TagDto> tagDtos) {
        super(id, name);
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.create_date = create_date;
        this.update_date = update_date;
        this.tags = tagDtos;
    }
    public GiftCertificateDto(){}

    public GiftCertificateDto(long id,
                              String name, String description,
                              BigDecimal price, int duration,
                              String create_date, String update_date) {
        super(id, name);
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.create_date = create_date;
        this.update_date = update_date;
    }
    public static GiftCertificateDto toDto(GiftCertificate certificate) {
        return new GiftCertificateDto(certificate.getId(),
                certificate.getName(),certificate.getDescription(),
                certificate.getPrice(),certificate.getDuration(),
                certificate.getCreate_date().toString(),certificate.getUpdate_date().toString(),
                TagDto.toDtoList(certificate.getTags()));
    }

    public static GiftCertificate toEntity(GiftCertificateDto dto) {
        return new GiftCertificate(dto.getId(),
                dto.getName(),dto.getDescription(),
                dto.getPrice(),dto.getDuration(),
                LocalDateTime.parse(dto.getCreate_date()),LocalDateTime.parse(dto.getUpdate_date()),
                TagDto.toEntityList(dto.getTags()));
    }

    public static List<GiftCertificateDto> toDtoList(List<GiftCertificate> list) {
        List<GiftCertificateDto> result = new ArrayList<>();
        list.forEach(i -> {
            result.add(toDto(i));
        });
        return result;
    }

    public static List<GiftCertificate> toEntityList(List<GiftCertificateDto> list) {
        List<GiftCertificate> result = new ArrayList<>();
        list.forEach(i -> {
            result.add(toEntity(i));
        });
        return result;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(String update_date) {
        this.update_date = update_date;
    }

    public List<TagDto> getTags() {
        return tags;
    }

    public void setTags(List<TagDto> tagDtos) {
        this.tags = tagDtos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GiftCertificateDto that = (GiftCertificateDto) o;
        return duration == that.duration && Objects.equals(description, that.description) && Objects.equals(price, that.price) && Objects.equals(create_date, that.create_date) && Objects.equals(update_date, that.update_date) && Objects.equals(tags, that.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), description, price, duration, create_date, update_date, tags);
    }

    @Override
    public String toString() {
        return "{\n" +
                "id=" + id +
                ",\n name='" + name + '\'' +
                ",\n description='" + description + '\'' +
                ",\n price=" + price +
                ",\n duration=" + duration +
                ",\n create_date='" + create_date + '\'' +
                ",\n update_date='" + update_date + '\'' +
                ",\n tags=" + tags +
                "}\n";
    }
}
