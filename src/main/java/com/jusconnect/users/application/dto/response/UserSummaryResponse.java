package com.jusconnect.users.application.dto.response;

import java.util.UUID;

public class UserSummaryResponse {

    private UUID id;
    private String name;
    private String type;

    public UserSummaryResponse() {
    }

    public UserSummaryResponse(
            UUID id,
            String name,
            String type
    ) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}