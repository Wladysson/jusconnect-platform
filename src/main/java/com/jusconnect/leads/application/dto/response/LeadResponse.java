package com.jusconnect.leads.application.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public class LeadResponse {

    private UUID id;
    private String name;
    private String email;
    private String phone;
    private String legalArea;
    private String status;
    private String priority;
    private String source;
    private LocalDateTime createdAt;

    public LeadResponse(
            UUID id,
            String name,
            String email,
            String phone,
            String legalArea,
            String status,
            String priority,
            String source,
            LocalDateTime createdAt
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.legalArea = legalArea;
        this.status = status;
        this.priority = priority;
        this.source = source;
        this.createdAt = createdAt;
    }

    public UUID getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getLegalArea() { return legalArea; }
    public String getStatus() { return status; }
    public String getPriority() { return priority; }
    public String getSource() { return source; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}