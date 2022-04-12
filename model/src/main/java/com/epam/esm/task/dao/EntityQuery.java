package com.epam.esm.task.dao;

public class EntityQuery {
    public static final String INSERT_GIFT = "INSERT INTO gift_certificate" +
            "(name,description,price,duration,create_date,last_update_date) " +
            "VALUES (?,?,?,?,?,?)";
    public static final String SELECT_GIFT = "SELECT * FROM gift_certificate;";
    public static final String UPDATE_GIFT = "UPDATE gift_certificate SET";
    public static final String DELETE_GIFT = "UPDATE gift_certificate SET deleted = 1 WHERE id = ?";
    public static final String FIND_BY_ID_GIFT = "";

    public static final String INSERT_TAG = "INSERT INTO tag(name) VALUES(?)";
    public static final String SELECT_TAG = "SELECT * FROM tag;";
    public static final String DELETE_TAG = "UPDATE tag set deleted = 1 WHERE id = ?";
    public static final String FIND_BY_ID_TAG = "SELECT * FROM tag WHERE id = ?";

    public static final String INSERT_MTM = "INSERT INTO gift_tag(gift_id,tag_id) VALUES(?,?)";
    public static final String SELECT_BY_GIFT_ID_MTM = "SELECT * FROM gift_tag WHERE gift_id = ?";
    public static final String DELETE_BY_GIFT_ID_MTM = "UPDATE FROM gift_tag SET deleted = 1 WHERE gift_id = ?";
    public static final String FIND_BY_TAG_ID_MTM = "SELECT * FROM gift_tag WHERE tag_id = ?";
}
