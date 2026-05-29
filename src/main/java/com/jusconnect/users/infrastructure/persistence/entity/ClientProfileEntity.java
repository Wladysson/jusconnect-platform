package com.jusconnect.users.infrastructure.persistence.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "client_profiles")
public class ClientProfileEntity extends PanacheEntityBase {

    @Id
    @Column(nullable = false, updatable = false)
    public UUID id;

    @Column(nullable = false)
    public UUID userId;

    @Column(nullable = false)
    public String cpf;

    @Column
    public String phone;
}