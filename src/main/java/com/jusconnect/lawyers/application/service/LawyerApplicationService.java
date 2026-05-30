package com.jusconnect.lawyers.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import com.jusconnect.lawyers.application.dto.request.CreateLawyerRequest;
import com.jusconnect.lawyers.application.dto.request.UpdateLawyerRequest;
import com.jusconnect.lawyers.application.dto.request.SearchLawyerRequest;
import com.jusconnect.lawyers.application.dto.request.UpdateAvailabilityRequest;
import com.jusconnect.lawyers.application.dto.request.AddExperienceRequest;
import com.jusconnect.lawyers.application.dto.request.CreateReviewRequest;

import com.jusconnect.lawyers.application.usecase.CreateLawyerUseCase;
import com.jusconnect.lawyers.application.usecase.UpdateLawyerUseCase;
import com.jusconnect.lawyers.application.usecase.GetLawyerByIdUseCase;
import com.jusconnect.lawyers.application.usecase.SearchLawyersUseCase;
import com.jusconnect.lawyers.application.usecase.UpdateAvailabilityUseCase;
import com.jusconnect.lawyers.application.usecase.AddExperienceUseCase;
import com.jusconnect.lawyers.application.usecase.CreateReviewUseCase;
import com.jusconnect.lawyers.application.usecase.GetLawyerStatisticsUseCase;
import com.jusconnect.lawyers.application.usecase.DeleteLawyerUseCase;

import com.jusconnect.lawyers.domain.model.Lawyer;
import com.jusconnect.lawyers.domain.model.LawyerAvailability;
import com.jusconnect.lawyers.domain.model.LawyerExperience;
import com.jusconnect.lawyers.domain.model.LawyerReview;
import com.jusconnect.lawyers.domain.model.LawyerStatistics;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class LawyerApplicationService {

    @Inject
    CreateLawyerUseCase createLawyerUseCase;

    @Inject
    UpdateLawyerUseCase updateLawyerUseCase;

    @Inject
    GetLawyerByIdUseCase getLawyerByIdUseCase;

    @Inject
    SearchLawyersUseCase searchLawyersUseCase;

    @Inject
    UpdateAvailabilityUseCase updateAvailabilityUseCase;

    @Inject
    AddExperienceUseCase addExperienceUseCase;

    @Inject
    CreateReviewUseCase createReviewUseCase;

    @Inject
    GetLawyerStatisticsUseCase getLawyerStatisticsUseCase;

    @Inject
    DeleteLawyerUseCase deleteLawyerUseCase;

    // ==================================================
    // LAWYER
    // ==================================================

    public Lawyer create(
            CreateLawyerRequest request
    ) {
        return createLawyerUseCase.execute(
                request
        );
    }

    public Lawyer update(
            UUID lawyerId,
            UpdateLawyerRequest request
    ) {
        return updateLawyerUseCase.execute(
                lawyerId,
                request
        );
    }

    public Lawyer findById(
            UUID lawyerId
    ) {
        return getLawyerByIdUseCase.execute(
                lawyerId
        );
    }

    public void delete(
            UUID lawyerId
    ) {
        deleteLawyerUseCase.execute(
                lawyerId
        );
    }

    // ==================================================
    // SEARCH
    // ==================================================

    public List<Lawyer> search(
            SearchLawyerRequest request
    ) {
        return searchLawyersUseCase.execute(
                request
        );
    }

    // ==================================================
    // AVAILABILITY
    // ==================================================

    public LawyerAvailability updateAvailability(
            UUID availabilityId,
            UpdateAvailabilityRequest request
    ) {
        return updateAvailabilityUseCase.execute(
                availabilityId,
                request
        );
    }

    // ==================================================
    // EXPERIENCE
    // ==================================================

    public LawyerExperience addExperience(
            UUID lawyerId,
            AddExperienceRequest request
    ) {
        return addExperienceUseCase.execute(
                lawyerId,
                request
        );
    }

    // ==================================================
    // REVIEW
    // ==================================================

    public LawyerReview createReview(
            UUID lawyerId,
            CreateReviewRequest request
    ) {
        return createReviewUseCase.execute(
                lawyerId,
                request
        );
    }

    // ==================================================
    // STATISTICS
    // ==================================================

    public LawyerStatistics statistics(
            UUID lawyerId
    ) {
        return getLawyerStatisticsUseCase.execute(
                lawyerId
        );
    }
}