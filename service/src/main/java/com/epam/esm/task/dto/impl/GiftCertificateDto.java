package com.epam.esm.task.dto.impl;

import com.epam.esm.task.dto.Dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class GiftCertificateDto extends Dto {
    private String description;
    private BigDecimal price;
    private int duration;
    private LocalDateTime create_date;
    private LocalDateTime update_date;
    private List<TagDto> tagDtos;

    public GiftCertificateDto(long id,
                              String name, String description,
                              BigDecimal price, int duration,
                              LocalDateTime create_date, LocalDateTime update_date, List<TagDto> tagDtos) {
        super(id, name);
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.create_date = create_date;
        this.update_date = update_date;
        this.tagDtos = tagDtos;
    }
    public GiftCertificateDto(){}

    public GiftCertificateDto(long id,
                              String name, String description,
                              BigDecimal price, int duration,
                              LocalDateTime create_date, LocalDateTime update_date) {
        super(id, name);
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.create_date = create_date;
        this.update_date = update_date;
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

    public LocalDateTime getCreate_date() {
        return create_date;
    }

    public void setCreate_date(LocalDateTime create_date) {
        this.create_date = create_date;
    }

    public LocalDateTime getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(LocalDateTime update_date) {
        this.update_date = update_date;
    }

    public List<TagDto> getTags() {
        return tagDtos;
    }

    public void setTags(List<TagDto> tagDtos) {
        this.tagDtos = tagDtos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GiftCertificateDto that = (GiftCertificateDto) o;
        return duration == that.duration && Objects.equals(description, that.description) && Objects.equals(price, that.price) && Objects.equals(create_date, that.create_date) && Objects.equals(update_date, that.update_date) && Objects.equals(tagDtos, that.tagDtos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), description, price, duration, create_date, update_date, tagDtos);
    }
}
