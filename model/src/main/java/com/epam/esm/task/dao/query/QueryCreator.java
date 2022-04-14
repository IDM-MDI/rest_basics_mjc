package com.epam.esm.task.dao.query;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class QueryCreator {

    private final String ID = "id";

    public String createQuery(QueryType type, String tableName, List<String> columns) {
        String query = "";
        switch (type) {
            case SELECT_BY_ID -> query = findById(tableName);
            case SELECT_ALL -> query = findAll(tableName);
            case INSERT -> query = insert(tableName,columns);
            case UPDATE -> query = update(tableName,columns);
            case DELETE -> query = delete(tableName);
        }
        return query;
    }

    private String delete(String tableName) {
        return "UPDATE " + tableName +
                " SET deleted = 1 " +
                "WHERE id = ?";
    }

    private String update(String tableName, List<String> columns) {
        return "UPDATE " + tableName + " SET " + fillColumn(columns) +
                " WHERE id = ?";
    }

    private String insert(String tableName, List<String> columns) {
        int count = 0;
        StringBuilder query = new StringBuilder("INSERT INTO " + tableName + "(");
        for (String i: columns) {
            if(!i.equals(ID)) {
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
        query.append(") VALUES(").append(fillQuestionMark(count)).append(");");
        return query.toString();
    }

    private String findAll(String tableName) {
        return "SELECT * FROM " + tableName;
    }

    private String findById(String tableName) {
        return "SELECT * FROM " + tableName + " WHERE id = ?";
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

    private String fillQuestionMark(int count) {
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
    private String fillColumn(List<String> columns) {
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
