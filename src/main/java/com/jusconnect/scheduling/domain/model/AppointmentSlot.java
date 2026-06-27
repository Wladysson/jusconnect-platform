package com.jusconnect.scheduling.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

public class AppointmentSlot {

    private UUID lawyerId;

    private LocalDate date;

    private LocalTime startTime;

    private LocalTime endTime;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    private Boolean available;

    public AppointmentSlot() {
    }

    public UUID getLawyerId() {
        return lawyerId;
    }

    public void setLawyerId(UUID lawyerId) {
        this.lawyerId = lawyerId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public boolean isAvailable() {
        return Boolean.TRUE.equals(available);
    }

    public boolean isUnavailable() {
        return !isAvailable();
    }

    public boolean contains(LocalDateTime dateTime) {

        if (dateTime == null ||
                startDateTime == null ||
                endDateTime == null) {
            return false;
        }

        return !dateTime.isBefore(startDateTime)
                && dateTime.isBefore(endDateTime);
    }
}