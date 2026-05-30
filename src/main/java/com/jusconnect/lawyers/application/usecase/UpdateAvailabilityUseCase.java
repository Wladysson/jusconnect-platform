package com.jusconnect.lawyers.application.usecase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;

import com.jusconnect.lawyers.domain.model.LawyerAvailability;
import com.jusconnect.lawyers.domain.repository.AvailabilityRepository;
import com.jusconnect.lawyers.application.dto.request.UpdateAvailabilityRequest;

import java.util.UUID;

@ApplicationScoped
public class UpdateAvailabilityUseCase {

    @Inject
    AvailabilityRepository availabilityRepository;

    public LawyerAvailability execute(
            UUID availabilityId,
            UpdateAvailabilityRequest request
    ) {

        LawyerAvailability availability =
                availabilityRepository
                        .findById(availabilityId)
                        .orElseThrow(() ->
                                new NotFoundException(
                                        "Disponibilidade não encontrada"
                                )
                        );

        availability.setWeekday(
                request.getWeekday()
        );

        availability.setStartTime(
                request.getStartTime()
        );

        availability.setEndTime(
                request.getEndTime()
        );

        availability.setOnline(
                request.isOnline()
        );

        availability.setActive(
                request.isActive()
        );

        availabilityRepository.save(
                availability
        );

        return availability;
    }
}