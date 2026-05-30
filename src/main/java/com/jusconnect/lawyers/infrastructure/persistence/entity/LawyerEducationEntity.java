package com.jusconnect.lawyers.infrastructure.persistence.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "lawyer_educations")
public class LawyerEducationEntity extends PanacheEntityBase {

    @Id
    public UUID id;

    @Column(nullable = false)
    public UUID lawyerId;

    @Column(nullable = false)
    public String institution;

    @Column(nullable = false)
    public String degree;

    @Column(nullable = false)
    public String fieldOfStudy;

    @Column(nullable = false)
    public LocalDate startDate;

    public LocalDate endDate;
}