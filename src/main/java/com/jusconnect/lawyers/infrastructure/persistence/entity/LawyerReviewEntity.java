package com.jusconnect.lawyers.infrastructure.persistence.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "lawyer_reviews")
public class LawyerReviewEntity extends PanacheEntityBase {

    @Id
    public UUID id;

    @Column(nullable = false)
    public UUID lawyerId;

    @Column(nullable = false)
    public UUID clientId;

    @Column(nullable = false)
    public Integer rating;

    @Column(length = 3000)
    public String comment;

    @Column(nullable = false)
    public String status;

    @Column(nullable = false)
    public LocalDateTime createdAt;
}