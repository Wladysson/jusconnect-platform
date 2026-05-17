package com.jusconnect.infrastructure.observability;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class TracingConfig {

    public String generateTraceId() {
        return UUID.randomUUID().toString();
    }
}