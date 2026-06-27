package com.jusconnect.scheduling.application.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public class AppointmentResponse {

    private UUID id;

    private UUID triageId;

    private UUID lawyerId;

    private UUID clientId;

    private LocalDateTime scheduledAt;

    private String appointmentType;

    private String meetingPlatform;

    private String status;

    public AppointmentResponse() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getTriageId() {
        return triageId;
    }

    public void setTriageId(UUID triageId) {
        this.triageId = triageId;
    }

    public UUID getLawyerId() {
        return lawyerId;
    }

    public void setLawyerId(UUID lawyerId) {
        this.lawyerId = lawyerId;
    }

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    public LocalDateTime getScheduledAt() {
        return scheduledAt;
    }

    public void setScheduledAt(LocalDateTime scheduledAt) {
        this.scheduledAt = scheduledAt;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }

    public String getMeetingPlatform() {
        return meetingPlatform;
    }

    public void setMeetingPlatform(String meetingPlatform) {
        this.meetingPlatform = meetingPlatform;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}