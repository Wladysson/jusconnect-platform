package com.jusconnect.scheduling.application.dto.request;

import java.util.UUID;

public class CancelAppointmentRequest {

    private UUID appointmentId;

    private String reason;

    private String cancelledBy;

    public CancelAppointmentRequest() {
    }

    public UUID getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(UUID appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getCancelledBy() {
        return cancelledBy;
    }

    public void setCancelledBy(String cancelledBy) {
        this.cancelledBy = cancelledBy;
    }
}