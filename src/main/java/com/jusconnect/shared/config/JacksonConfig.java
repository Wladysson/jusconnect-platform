package com.jusconnect.shared.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class JacksonConfig {

    @Produces
    public ObjectMapper objectMapper() {

        ObjectMapper mapper = new ObjectMapper();

        mapper.findAndRegisterModules();

        mapper.disable(
                SerializationFeature.WRITE_DATES_AS_TIMESTAMPS
        );

        return mapper;
    }
}