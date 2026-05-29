package com.jusconnect.users.infrastructure.persistence.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "documents")
public class DocumentEntity extends PanacheEntityBase {

    @Id
    @Column(nullable = false, updatable = false)
    public UUID id;

    @Column(nullable = false)
    public UUID userId;

    @Column(nullable = false)
    public String type;

    @Column(nullable = false)
    public String fileUrl;

    @Column(nullable = false)
    public boolean verified;

    @Column
    public LocalDateTime createdAt;
}