package com.jusconnect.scheduling.application.dto.request;

import java.time.LocalDateTime;
import java.util.UUID;

public class RescheduleAppointmentRequest {

    private UUID appointmentId;

    private LocalDateTime newScheduledAt;

    private String reason;

    public RescheduleAppointmentRequest() {
    }

    public UUID getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(UUID appointmentId) {
        this.appointmentId = appointmentId;
    }

    public LocalDateTime getNewScheduledAt() {
        return newScheduledAt;
    }

    public void setNewScheduledAt(LocalDateTime newScheduledAt) {
        this.newScheduledAt = newScheduledAt;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}