package com.jusconnect.infrastructure.observability;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MetricsConfig {

    private final Counter requestCounter;

    public MetricsConfig(
            MeterRegistry registry
    ) {

        this.requestCounter = Counter.builder(
                        "jusconnect.requests.total"
                )
                .description(
                        "Total HTTP requests"
                )
                .register(registry);
    }

    public void incrementRequests() {
        requestCounter.increment();
    }
}