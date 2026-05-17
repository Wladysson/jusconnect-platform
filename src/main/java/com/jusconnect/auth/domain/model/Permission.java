package com.jusconnect.auth.domain.model;

import java.util.Objects;
import java.util.UUID;

public class Permission {

    private UUID id;

    private String name;

    private String description;

    public Permission() {
    }

    public Permission(UUID id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Permission that)) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}