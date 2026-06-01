package com.jusconnect.leads.infrastructure.persistence.repository;

import jakarta.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import com.jusconnect.leads.infrastructure.persistence.entity.LeadAssignmentEntity;

@ApplicationScoped
public class LeadAssignmentPanacheRepository
        implements PanacheRepository<LeadAssignmentEntity> {
}