package com.epam.esm.task.validator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ParameterValidator {
    public static Map<String,String> getValidMap(Map<String,String> requestParam,
                                          List<String> columns) {
        Map<String,String> validMap = new HashMap<>();

        for (String i: requestParam.keySet()) {
            for (String j: columns) {
                if(i.equals(j)) {
                    validMap.put(i,requestParam.get(i));
                }
            }
        }
        return validMap;
    }
}
