package com.jusconnect.lawyers.application.dto.response;

import java.time.LocalDate;
import java.util.UUID;

public class ExperienceResponse {

    private UUID id;
    private String company;
    private String role;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    public ExperienceResponse() {
    }

    public ExperienceResponse(
            UUID id,
            String company,
            String role,
            String description,
            LocalDate startDate,
            LocalDate endDate
    ) {
        this.id = id;
        this.company = company;
        this.role = role;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}