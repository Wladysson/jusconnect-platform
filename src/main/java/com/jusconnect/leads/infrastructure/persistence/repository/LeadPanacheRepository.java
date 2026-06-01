package com.jusconnect.leads.infrastructure.persistence.repository;

import jakarta.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import com.jusconnect.leads.infrastructure.persistence.entity.LeadEntity;

@ApplicationScoped
public class LeadPanacheRepository
        implements PanacheRepository<LeadEntity> {
}