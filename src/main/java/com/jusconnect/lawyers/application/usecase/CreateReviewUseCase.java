package com.jusconnect.lawyers.application.usecase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;

import com.jusconnect.lawyers.domain.model.Lawyer;
import com.jusconnect.lawyers.domain.model.LawyerReview;
import com.jusconnect.lawyers.domain.repository.LawyerRepository;
import com.jusconnect.lawyers.domain.repository.ReviewRepository;
import com.jusconnect.lawyers.application.dto.request.CreateReviewRequest;

import java.time.LocalDateTime;
import java.util.UUID;

@ApplicationScoped
public class CreateReviewUseCase {

    @Inject
    LawyerRepository lawyerRepository;

    @Inject
    ReviewRepository reviewRepository;

    public LawyerReview execute(
            UUID lawyerId,
            CreateReviewRequest request
    ) {

        Lawyer lawyer =
                lawyerRepository
                        .findById(lawyerId)
                        .orElseThrow(() ->
                                new NotFoundException(
                                        "Advogado não encontrado"
                                )
                        );

        LawyerReview review =
                new LawyerReview();

        review.setId(
                UUID.randomUUID()
        );

        review.setLawyerId(
                lawyer.getId()
        );

        review.setClientId(
                request.getClientId()
        );

        review.setRating(
                request.getRating()
        );

        review.setComment(
                request.getComment()
        );

        review.setCreatedAt(
                LocalDateTime.now()
        );

        reviewRepository.save(
                review
        );

        return review;
    }
}