package com.jusconnect.users.infrastructure.persistence.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity extends PanacheEntityBase {

    @Id
    @Column(nullable = false, updatable = false)
    public UUID id;

    @Column(nullable = false)
    public String name;

    @Column(nullable = false, unique = true)
    public String email;

    @Column(nullable = false)
    public String passwordHash;

    @Column(nullable = false)
    public String status;

    @Column(nullable = false)
    public String type;

    @Column
    public LocalDateTime createdAt;

    @Column
    public LocalDateTime updatedAt;
}