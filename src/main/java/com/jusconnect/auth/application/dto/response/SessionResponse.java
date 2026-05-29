package com.jusconnect.auth.application.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public class SessionResponse {

    private UUID id;

    private String device;

    private String ipAddress;

    private LocalDateTime createdAt;

    private LocalDateTime expiresAt;

    private Boolean active;

    public SessionResponse() {
    }

    public SessionResponse(
            UUID id,
            String device,
            String ipAddress,
            LocalDateTime createdAt,
            LocalDateTime expiresAt,
            Boolean active
    ) {
        this.id = id;
        this.device = device;
        this.ipAddress = ipAddress;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.active = active;
    }

    public UUID getId() {
        return id;
    }

    public void setId(
            UUID id
    ) {
        this.id = id;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(
            String device
    ) {
        this.device = device;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(
            String ipAddress
    ) {
        this.ipAddress = ipAddress;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(
            LocalDateTime createdAt
    ) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(
            LocalDateTime expiresAt
    ) {
        this.expiresAt = expiresAt;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(
            Boolean active
    ) {
        this.active = active;
    }
}