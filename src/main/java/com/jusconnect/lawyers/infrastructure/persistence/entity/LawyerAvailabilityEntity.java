package com.jusconnect.lawyers.infrastructure.persistence.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "lawyer_availabilities")
public class LawyerAvailabilityEntity extends PanacheEntityBase {

    @Id
    public UUID id;

    @Column(nullable = false)
    public UUID lawyerId;

    @Column(nullable = false)
    public String weekday;

    @Column(nullable = false)
    public LocalTime startTime;

    @Column(nullable = false)
    public LocalTime endTime;

    @Column(nullable = false)
    public boolean online;

    @Column(nullable = false)
    public boolean active;
}