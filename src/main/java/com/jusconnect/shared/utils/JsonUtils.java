package com.jusconnect.shared.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class JsonUtils {

    private static final ObjectMapper MAPPER =
            new ObjectMapper();

    private JsonUtils() {
    }

    public static String toJson(Object object) {

        try {
            return MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException exception) {
            throw new RuntimeException(
                    "Erro ao converter objeto para JSON",
                    exception
            );
        }
    }
}