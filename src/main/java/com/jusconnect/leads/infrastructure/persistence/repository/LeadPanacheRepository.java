package com.jusconnect.leads.infrastructure.persistence.repository;

import jakarta.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import com.jusconnect.leads.infrastructure.persistence.entity.LeadEntity;

import java.util.UUID;

@ApplicationScoped
public class LeadPanacheRepository
        implements PanacheRepositoryBase<
        LeadEntity,
        UUID
        > {
}