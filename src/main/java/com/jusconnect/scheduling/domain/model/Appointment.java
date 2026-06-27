package com.jusconnect.scheduling.domain.model;

import com.jusconnect.scheduling.domain.enums.AppointmentStatus;
import com.jusconnect.scheduling.domain.enums.AppointmentType;
import com.jusconnect.scheduling.domain.enums.MeetingPlatform;

import java.time.LocalDateTime;
import java.util.UUID;

public class Appointment {

    private UUID id;

    private UUID triageId;

    private UUID lawyerId;

    private UUID clientId;

    private LocalDateTime scheduledAt;

    private AppointmentType appointmentType;

    private MeetingPlatform meetingPlatform;

    private String meetingLink;

    private String notes;

    private AppointmentStatus status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Appointment() {
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

    public AppointmentType getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(AppointmentType appointmentType) {
        this.appointmentType = appointmentType;
    }

    public MeetingPlatform getMeetingPlatform() {
        return meetingPlatform;
    }

    public void setMeetingPlatform(MeetingPlatform meetingPlatform) {
        this.meetingPlatform = meetingPlatform;
    }

    public String getMeetingLink() {
        return meetingLink;
    }

    public void setMeetingLink(String meetingLink) {
        this.meetingLink = meetingLink;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isPending() {
        return AppointmentStatus.PENDING.equals(status);
    }

    public boolean isConfirmed() {
        return AppointmentStatus.CONFIRMED.equals(status);
    }

    public boolean isCancelled() {
        return AppointmentStatus.CANCELLED.equals(status);
    }

    public boolean isCompleted() {
        return AppointmentStatus.COMPLETED.equals(status);
    }

    public boolean canBeCancelled() {
        return !isCancelled() && !isCompleted();
    }

    public boolean canBeRescheduled() {
        return !isCancelled() && !isCompleted();
    }

    public void confirm() {
        this.status = AppointmentStatus.CONFIRMED;
    }

    public void cancel() {
        this.status = AppointmentStatus.CANCELLED;
    }

    public void complete() {
        this.status = AppointmentStatus.COMPLETED;
    }

    public void reschedule(LocalDateTime newDateTime) {
        this.scheduledAt = newDateTime;
        this.status = AppointmentStatus.RESCHEDULED;
    }

    public LocalDateTime getAppointmentDateTime() {
        return scheduledAt;
    }
}