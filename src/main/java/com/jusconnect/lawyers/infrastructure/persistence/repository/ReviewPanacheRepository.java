package com.jusconnect.lawyers.infrastructure.persistence.repository;

import jakarta.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import com.jusconnect.lawyers.infrastructure.persistence.entity.LawyerReviewEntity;

import java.util.UUID;

@ApplicationScoped
public class ReviewPanacheRepository
        implements PanacheRepositoryBase<
        LawyerReviewEntity,
        UUID> {
    public void persistOrUpdate(LawyerReviewEntity entity) {
    }
}