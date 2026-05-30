package com.jusconnect.lawyers.application.usecase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;

import com.jusconnect.lawyers.domain.model.Lawyer;
import com.jusconnect.lawyers.domain.model.LawyerStatistics;
import com.jusconnect.lawyers.domain.repository.LawyerRepository;
import com.jusconnect.lawyers.domain.repository.ReviewRepository;

import java.math.BigDecimal;
import java.util.UUID;

@ApplicationScoped
public class GetLawyerStatisticsUseCase {

    @Inject
    LawyerRepository lawyerRepository;

    @Inject
    ReviewRepository reviewRepository;

    public LawyerStatistics execute(
            UUID lawyerId
    ) {

        Lawyer lawyer =
                lawyerRepository
                        .findById(lawyerId)
                        .orElseThrow(() ->
                                new NotFoundException(
                                        "Advogado não encontrado"
                                )
                        );

        Integer totalReviews =
                reviewRepository.countByLawyerId(
                        lawyerId
                );

        BigDecimal averageRating =
                reviewRepository.averageRating(
                        lawyerId
                );

        LawyerStatistics statistics =
                new LawyerStatistics();

        statistics.setLawyerId(
                lawyer.getId()
        );

        statistics.setTotalReviews(
                totalReviews
        );

        statistics.setAverageRating(
                averageRating
        );

        statistics.setCompletedCases(
                0
        );

        statistics.setResponseTime(
                0
        );

        return statistics;
    }
}