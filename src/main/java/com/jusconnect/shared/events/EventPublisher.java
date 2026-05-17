package com.jusconnect.shared.events;

public interface EventPublisher {

    void publish(
            String topic,
            IntegrationEvent event
    );
}