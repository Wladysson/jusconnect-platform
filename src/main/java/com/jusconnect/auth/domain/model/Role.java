package com.jusconnect.auth.domain.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class Role {

    private UUID id;

    private String name;

    private String description;

    private Set<Permission> permissions = new HashSet<>();

    public Role() {
    }

    public Role(UUID id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public void addPermission(Permission permission) {
        this.permissions.add(permission);
    }

    public boolean hasPermission(String permissionName) {
        return permissions.stream()
                .anyMatch(permission ->
                        permission.getName().equalsIgnoreCase(permissionName)
                );
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

    public Set<Permission> getPermissions() {
        return permissions;
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

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role role)) return false;
        return Objects.equals(name, role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}