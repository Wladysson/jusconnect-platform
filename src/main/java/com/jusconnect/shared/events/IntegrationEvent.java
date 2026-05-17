package com.jusconnect.shared.events;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class IntegrationEvent {

    private final UUID eventId;

    private final LocalDateTime occurredAt;

    protected IntegrationEvent() {
        this.eventId = UUID.randomUUID();
        this.occurredAt = LocalDateTime.now();
    }

    public UUID getEventId() {
        return eventId;
    }

    public LocalDateTime getOccurredAt() {
        return occurredAt;
    }

    public abstract String getEventType();
}