package com.epam.esm.task.dao;

import com.epam.esm.task.entity.impl.Tag;

import java.util.List;

public interface TagDao extends CrdDao<Tag,Long>{
    void createWithList(List<Tag> tagList);
}
