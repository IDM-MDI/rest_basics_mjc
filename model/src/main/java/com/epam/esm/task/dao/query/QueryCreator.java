package com.epam.esm.task.dao.query;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class QueryCreator {

    private final String ID = "id";
    private final String DELETED = "deleted";

    public String delete(String tableName) {
        return "UPDATE " + tableName +
                " SET deleted = 1 " +
                "WHERE id = ? ;";
    }

    public String update(String tableName, List<String> columns) {
        return "UPDATE " + tableName + " SET " + fillColumnQuestionMark(columns) +
                " WHERE id = ? ;";
    }

    public String insert(String tableName, List<String> columns) {
        int count = 0;
        StringBuilder query = new StringBuilder("INSERT INTO " + tableName + "(");
        for (String i: columns) {
            if(!i.equals(ID) && !i.equals(DELETED)) {
                if(count == 0) {
                    query.append(i);
                }
                else {
                    query.append(",").
                            append(i);
                }
                count++;
            }
        }
        query.append(") VALUES(").append(fillInsertQuestionMark(count)).append(");");
        return query.toString();
    }

    public String findAll(String tableName) {
        return "SELECT * FROM " + tableName + ";";
    }

    public String findById(String tableName) {
        return "SELECT * FROM " + tableName + " WHERE id = ? ;";
    }

    public String findByParam(String tableName, Map<String,String> param) {
        StringBuilder result = new StringBuilder();
        result.append("SELECT * FROM ").append(tableName).append(" WHERE ");
        param.forEach((k,v) -> {
            result.append(k).append("=").append('\'').append(v).append('\'').append(" AND ");
        });
        result.delete(result.length()-4,result.length()-1);
        return result.append(";").toString();
    }

    private String fillInsertQuestionMark(int count) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            if(i == 0) {
                result.append("?");
            }
            else {
                result.append(",?");
            }
        }
        return result.toString();
    }
    private String fillColumnQuestionMark(List<String> columns) {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        String equal = " = ?";
        for (String i : columns) {
            if (!i.equals(ID)) {
                if (first) {
                    first = false;
                    result.append(i).append(equal);
                } else {
                    result.append(",").
                            append(i).append(equal);
                }
            }
        }
        return result.toString();
    }
}
