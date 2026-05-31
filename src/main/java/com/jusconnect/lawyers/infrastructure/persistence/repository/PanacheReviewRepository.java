package com.jusconnect.lawyers.infrastructure.persistence.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import com.jusconnect.lawyers.domain.model.LawyerReview;
import com.jusconnect.lawyers.domain.repository.ReviewRepository;

import com.jusconnect.lawyers.infrastructure.persistence.entity.LawyerReviewEntity;
import com.jusconnect.lawyers.infrastructure.persistence.mapper.LawyerPersistenceMapper;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class PanacheReviewRepository
        implements ReviewRepository,
        PanacheRepositoryBase<Optional<LawyerReview>, UUID> {

    @Inject
    LawyerPersistenceMapper mapper;

    @Override
    public void save(
            LawyerReview review
    ) {

        LawyerReviewEntity entity =
                mapper.toEntity(
                        review
                );

        persistOrUpdate(entity);
    }

    private void persistOrUpdate(LawyerReviewEntity entity) {
    }

    @Override
    public Optional<LawyerReview> findById(
            UUID id
    ) {

        return find(
                "id",
                id
        )
                .firstResultOptional()
                .map(mapper::toDomain);
    }

    @Override
    public Integer countByLawyerId(
            UUID lawyerId
    ) {

        return (int) count(
                "lawyerId",
                lawyerId
        );
    }

    @Override
    public BigDecimal averageRating(
            UUID lawyerId
    ) {

        Double avg =
                find(
                        "select avg(rating) from LawyerReviewEntity where lawyerId = ?1",
                        lawyerId
                )
                        .project(Double.class)
                        .firstResult();

        if (avg == null) {
            return BigDecimal.ZERO;
        }

        return BigDecimal.valueOf(avg);
    }
}