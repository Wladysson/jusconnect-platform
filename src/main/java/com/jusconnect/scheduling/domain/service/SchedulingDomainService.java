package com.jusconnect.scheduling.domain.service;

import com.jusconnect.scheduling.domain.enums.AppointmentStatus;
import com.jusconnect.scheduling.domain.model.Appointment;
import com.jusconnect.scheduling.domain.model.AppointmentSlot;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class SchedulingDomainService {

    private final AppointmentValidationService appointmentValidationService;

    private final AvailabilityService availabilityService;

    private final SlotGenerationService slotGenerationService;

    public SchedulingDomainService(
            AppointmentValidationService appointmentValidationService,
            AvailabilityService availabilityService,
            SlotGenerationService slotGenerationService
    ) {
        this.appointmentValidationService = appointmentValidationService;
        this.availabilityService = availabilityService;
        this.slotGenerationService = slotGenerationService;
    }

    public void validateAppointment(
            Appointment appointment
    ) {
        appointmentValidationService.validateAppointment(
                appointment
        );
    }

    public void validateAvailability(
            Appointment appointment
    ) {
        availabilityService.validateAvailability(
                appointment
        );
    }

    public void validateReschedule(
            Appointment appointment,
            LocalDateTime newDateTime
    ) {
        appointmentValidationService.validateReschedule(
                appointment,
                newDateTime
        );
    }

    public void validateCancellation(
            Appointment appointment
    ) {
        appointmentValidationService.validateCancellation(
                appointment
        );
    }

    public void validateConfirmation(
            Appointment appointment
    ) {
        appointmentValidationService.validateConfirmation(
                appointment
        );
    }

    public void validateCompletion(
            Appointment appointment
    ) {
        appointmentValidationService.validateCompletion(
                appointment
        );
    }

    public void validateLawyerAssignment(
            Appointment appointment,
            UUID lawyerId
    ) {
        availabilityService.validateLawyerAssignment(
                appointment,
                lawyerId
        );
    }

    public AppointmentStatus initialStatus() {
        return AppointmentStatus.PENDING;
    }

    public List<AppointmentSlot> calculateAvailableSlots(
            UUID lawyerId,
            LocalDate date,
            List<AppointmentSlot> occupiedSlots
    ) {
        return slotGenerationService.generateAvailableSlots(
                lawyerId,
                date,
                occupiedSlots
        );
    }

}