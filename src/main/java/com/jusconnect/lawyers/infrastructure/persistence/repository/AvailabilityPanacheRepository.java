package com.jusconnect.lawyers.infrastructure.persistence.repository;

import jakarta.enterprise.context.ApplicationScoped;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import com.jusconnect.lawyers.infrastructure.persistence.entity.LawyerAvailabilityEntity;

import java.util.UUID;

@ApplicationScoped
public class AvailabilityPanacheRepository
        implements PanacheRepositoryBase<LawyerAvailabilityEntity, UUID> {
    public void persistOrUpdate(LawyerAvailabilityEntity entity) {
    }
}