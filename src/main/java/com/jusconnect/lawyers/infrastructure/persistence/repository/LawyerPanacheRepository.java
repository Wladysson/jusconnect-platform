package com.jusconnect.lawyers.infrastructure.persistence.repository;

import jakarta.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import com.jusconnect.lawyers.infrastructure.persistence.entity.LawyerEntity;

import java.util.UUID;

@ApplicationScoped
public class LawyerPanacheRepository
        implements PanacheRepositoryBase<
        LawyerEntity,
        UUID> {
    public void persistOrUpdate(LawyerEntity entity) {
    }
}