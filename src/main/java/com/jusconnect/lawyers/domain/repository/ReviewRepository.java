package com.jusconnect.lawyers.domain.repository;

import com.jusconnect.lawyers.domain.model.LawyerReview;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface ReviewRepository {

    LawyerReview save(
            LawyerReview review
    );

    List<LawyerReview> findByLawyerId(
            UUID lawyerId
    );

    void deleteById(
            UUID id
    );

    Integer countByLawyerId(UUID lawyerId);

    BigDecimal averageRating(UUID lawyerId);
}