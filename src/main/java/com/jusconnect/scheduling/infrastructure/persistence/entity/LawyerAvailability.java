package com.jusconnect.scheduling.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "lawyer_availability")
public class LawyerAvailability {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private UUID lawyerId;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    @Column(nullable = false)
    private boolean available;

    // getters and setters
}