package com.jusconnect.lawyers.application.mapper;

import jakarta.enterprise.context.ApplicationScoped;

import com.jusconnect.lawyers.domain.model.Lawyer;
import com.jusconnect.lawyers.domain.model.LawyerAvailability;
import com.jusconnect.lawyers.domain.model.LawyerReview;
import com.jusconnect.lawyers.domain.model.LawyerExperience;
import com.jusconnect.lawyers.domain.model.LawyerStatistics;

import com.jusconnect.lawyers.application.dto.response.LawyerResponse;
import com.jusconnect.lawyers.application.dto.response.LawyerSummaryResponse;
import com.jusconnect.lawyers.application.dto.response.AvailabilityResponse;
import com.jusconnect.lawyers.application.dto.response.ReviewResponse;
import com.jusconnect.lawyers.application.dto.response.ExperienceResponse;
import com.jusconnect.lawyers.application.dto.response.LawyerStatisticsResponse;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class LawyerMapper {

    public LawyerResponse toResponse(
            Lawyer lawyer
    ) {

        if (lawyer == null) {
            return null;
        }

        return new LawyerResponse(
                lawyer.getId(),
                lawyer.getUserId(),
                lawyer.getOabNumber(),
                lawyer.getStateBar(),
                lawyer.getBio(),
                lawyer.getLevel() != null
                        ? lawyer.getLevel().name()
                        : null,
                lawyer.isVerified(),
                lawyer.getCreatedAt()
        );
    }

    public LawyerSummaryResponse toSummary(
            Lawyer lawyer
    ) {

        if (lawyer == null) {
            return null;
        }

        return new LawyerSummaryResponse(
                lawyer.getId(),
                lawyer.getOabNumber(),
                lawyer.getLevel() != null
                        ? lawyer.getLevel().name()
                        : null,
                lawyer.isVerified()
        );
    }

    public AvailabilityResponse toResponse(
            LawyerAvailability availability
    ) {

        if (availability == null) {
            return null;
        }

        return new AvailabilityResponse(
                availability.getId(),
                availability.getWeekday(),
                availability.getStartTime(),
                availability.getEndTime(),
                availability.isOnline(),
                availability.isActive()
        );
    }

    public List<AvailabilityResponse> toAvailabilityList(
            List<LawyerAvailability> availabilities
    ) {

        if (availabilities == null) {
            return List.of();
        }

        return availabilities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public ReviewResponse toResponse(
            LawyerReview review
    ) {

        if (review == null) {
            return null;
        }

        return new ReviewResponse(
                review.getId(),
                review.getClientId(),
                review.getRating(),
                review.getComment(),
                review.getCreatedAt()
        );
    }

    public List<ReviewResponse> toReviewList(
            List<LawyerReview> reviews
    ) {

        if (reviews == null) {
            return List.of();
        }

        return reviews.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public ExperienceResponse toResponse(
            LawyerExperience experience
    ) {

        if (experience == null) {
            return null;
        }

        return new ExperienceResponse(
                experience.getId(),
                experience.getCompany(),
                experience.getRole(),
                experience.getDescription(),
                experience.getStartDate(),
                experience.getEndDate()
        );
    }

    public List<ExperienceResponse> toExperienceList(
            List<LawyerExperience> experiences
    ) {

        if (experiences == null) {
            return List.of();
        }

        return experiences.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public LawyerStatisticsResponse toResponse(
            LawyerStatistics statistics
    ) {

        if (statistics == null) {
            return null;
        }

        return new LawyerStatisticsResponse(
                statistics.getLawyerId(),
                statistics.getTotalReviews(),
                statistics.getAverageRating(),
                statistics.getCompletedCases(),
                statistics.getResponseTime()
        );
    }
}