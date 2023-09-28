package com.example.deneme.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static com.example.deneme.helper.LogHelperService.errorLogger;

public class LogMapper {
    public static String mapToJsonString(Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            errorLogger("LogMapper", "mapToJsonString", e.getMessage());
        }
        return null;
    }
}
