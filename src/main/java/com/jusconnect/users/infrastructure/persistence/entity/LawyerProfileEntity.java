package com.jusconnect.users.infrastructure.persistence.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "lawyer_profiles")
public class LawyerProfileEntity extends PanacheEntityBase {

    @Id
    @Column(nullable = false, updatable = false)
    public UUID id;

    @Column(nullable = false)
    public UUID userId;

    @Column(nullable = false)
    public String oabNumber;

    @Column
    public String state;

    @Column
    public String specialty;

    @Column(columnDefinition = "TEXT")
    public String bio;
}