package com.jusconnect.scheduling.domain.model;

import com.jusconnect.scheduling.domain.enums.AppointmentStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class AppointmentHistory {

    private UUID id;

    private UUID appointmentId;

    private AppointmentStatus previousStatus;

    private AppointmentStatus currentStatus;

    private String changedBy;

    private String reason;

    private LocalDateTime changedAt;

    public AppointmentHistory() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(UUID appointmentId) {
        this.appointmentId = appointmentId;
    }

    public AppointmentStatus getPreviousStatus() {
        return previousStatus;
    }

    public void setPreviousStatus(AppointmentStatus previousStatus) {
        this.previousStatus = previousStatus;
    }

    public AppointmentStatus getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(AppointmentStatus currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getChangedBy() {
        return changedBy;
    }

    public void setChangedBy(String changedBy) {
        this.changedBy = changedBy;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDateTime getChangedAt() {
        return changedAt;
    }

    public void setChangedAt(LocalDateTime changedAt) {
        this.changedAt = changedAt;
    }
}