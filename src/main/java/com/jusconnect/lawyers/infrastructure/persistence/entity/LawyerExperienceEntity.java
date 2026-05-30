package com.jusconnect.lawyers.infrastructure.persistence.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "lawyer_experiences")
public class LawyerExperienceEntity extends PanacheEntityBase {

    @Id
    public UUID id;

    @Column(nullable = false)
    public UUID lawyerId;

    @Column(nullable = false)
    public String company;

    @Column(nullable = false)
    public String role;

    @Column(length = 3000)
    public String description;

    @Column(nullable = false)
    public LocalDate startDate;

    public LocalDate endDate;
}