package com.jusconnect.lawyers.domain.repository;

import com.jusconnect.lawyers.domain.model.LawyerReview;

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
}