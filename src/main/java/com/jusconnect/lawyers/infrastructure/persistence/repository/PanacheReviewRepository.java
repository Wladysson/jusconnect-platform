package com.jusconnect.lawyers.infrastructure.persistence.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import com.jusconnect.lawyers.domain.model.LawyerReview;
import com.jusconnect.lawyers.domain.repository.ReviewRepository;

import com.jusconnect.lawyers.infrastructure.persistence.mapper.LawyerPersistenceMapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class PanacheReviewRepository
        implements ReviewRepository {

    @Inject
    ReviewPanacheRepository panache;

    @Inject
    LawyerPersistenceMapper mapper;

    @Override
    public LawyerReview save(
            LawyerReview review
    ) {

        var entity =
                mapper.toEntity(review);

        panache.persistOrUpdate(entity);

        return mapper.toDomain(entity);
    }

    @Override
    public Optional<LawyerReview> findById(
            UUID id
    ) {

        return panache.find(
                        "id",
                        id
                )
                .firstResultOptional()
                .map(
                        mapper::toDomain
                );
    }

    @Override
    public List<LawyerReview> findByLawyerId(
            UUID lawyerId
    ) {

        return panache.find(
                        "lawyerId",
                        lawyerId
                )
                .list()
                .stream()
                .map(
                        mapper::toDomain
                )
                .toList();
    }

    @Override
    public void deleteById(
            UUID id
    ) {

        panache.delete(
                "id",
                id
        );
    }

    @Override
    public Integer countByLawyerId(UUID lawyerId) {
        return 0;
    }

    @Override
    public BigDecimal averageRating(UUID lawyerId) {
        return null;
    }
}