package com.epam.esm.task.entity.impl;

import com.epam.esm.task.entity.Entity;

public class Tag extends Entity {

    private String name;

    public Tag(){}

    public Tag(long id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tag {").
                append(" id = ").append(id).
                append(", name = ").append(name).
                append(" }");
        return sb.toString();
    }

}
