package com.jusconnect.lawyers.application.dto.response;

import java.time.LocalTime;
import java.util.UUID;

public class AvailabilityResponse {

    private UUID id;
    private String weekday;
    private LocalTime startTime;
    private LocalTime endTime;
    private boolean online;
    private boolean active;

    public AvailabilityResponse() {
    }

    public AvailabilityResponse(
            UUID id,
            String weekday,
            LocalTime startTime,
            LocalTime endTime,
            boolean online,
            boolean active
    ) {
        this.id = id;
        this.weekday = weekday;
        this.startTime = startTime;
        this.endTime = endTime;
        this.online = online;
        this.active = active;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
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

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}