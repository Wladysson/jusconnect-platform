package com.jusconnect.lawyers.infrastructure.persistence.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "lawyers")
public class LawyerEntity extends PanacheEntityBase {

    @Id
    public UUID id;

    @Column(nullable = false, unique = true)
    public UUID userId;

    @Column(nullable = false, unique = true)
    public String oabNumber;

    @Column(nullable = false)
    public String stateBar;

    @Column(length = 3000)
    public String bio;

    @Column(nullable = false)
    public String level;

    @Column(nullable = false)
    public boolean verified;

    @Column(nullable = false)
    public LocalDateTime createdAt;

    public LocalDateTime updatedAt;
}