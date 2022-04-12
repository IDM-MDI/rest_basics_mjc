package com.epam.esm.task.dto.impl;

import com.epam.esm.task.dto.Dto;

public class TagDto extends Dto {

    public TagDto(){}

    public TagDto(long id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TagDto {").
                append(" id = ").append(id).
                append(", name = ").append(name).
                append(" }");
        return sb.toString();
    }

}
