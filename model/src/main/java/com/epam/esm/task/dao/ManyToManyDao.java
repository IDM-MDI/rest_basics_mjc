package com.epam.esm.task.dao;

import com.epam.esm.task.entity.impl.ManyToMany;
import com.epam.esm.task.entity.impl.Tag;

import java.util.List;

public interface ManyToManyDao {
    List<ManyToMany> findByGiftId(long id);
    List<ManyToMany> findByTagId(long id);
    void create(long giftId,List<Tag> tagList);
    void update(long giftId,List<Tag> tagList);
    void deleteByGiftId(long id);
    void deleteByTagId(long id);
}
