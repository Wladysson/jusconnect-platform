package com.jusconnect.shared.events;

public interface EventConsumer<T extends IntegrationEvent> {

    void consume(T event);
}