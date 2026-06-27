package com.jusconnect.scheduling.domain.service;

import com.jusconnect.scheduling.domain.enums.AppointmentStatus;
import com.jusconnect.scheduling.domain.model.Appointment;
import com.jusconnect.scheduling.domain.model.AppointmentSlot;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
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

    // =========================
    // VALIDATIONS
    // =========================

    public void validateAppointment(Appointment appointment) {
        appointmentValidationService.validateAppointment(appointment);
    }

    public void validateAvailability(Appointment appointment) {
        availabilityService.validateAvailability(appointment);
    }

    public void validateReschedule(Appointment appointment, LocalDateTime newDateTime) {
        appointmentValidationService.validateReschedule(appointment, newDateTime);
    }

    public void validateCancellation(Appointment appointment) {
        appointmentValidationService.validateCancellation(appointment);
    }

    public void validateConfirmation(Appointment appointment) {
        appointmentValidationService.validateConfirmation(appointment);
    }

    public void validateCompletion(Appointment appointment) {
        appointmentValidationService.validateCompletion(appointment);
    }

    public void validateLawyerAssignment(Appointment appointment, UUID lawyerId) {
        availabilityService.validateLawyerAssignment(appointment, lawyerId);
    }

    public AppointmentStatus initialStatus() {
        return AppointmentStatus.PENDING;
    }

    public List<AppointmentSlot> generateAvailableSlots(
            UUID lawyerId,
            LocalDate date,
            List<Appointment> occupiedAppointments
    ) {

        List<AppointmentSlot> slots = new ArrayList<>();

        LocalTime start = LocalTime.of(9, 0);
        LocalTime end = LocalTime.of(18, 0);
        int slotMinutes = 60;

        for (LocalTime time = start;
             time.isBefore(end);
             time = time.plusMinutes(slotMinutes)) {

            LocalTime slotEnd = time.plusMinutes(slotMinutes);

            LocalTime finalTime = time;
            boolean occupied = occupiedAppointments.stream().anyMatch(app ->
                    app.getStartTime().toLocalTime().isBefore(slotEnd) &&
                            app.getEndTime().toLocalTime().isAfter(finalTime)
            );

            if (!occupied) {
                slots.add(new AppointmentSlot(date, time, slotEnd));
            }
        }

        return slots;
    }

    public List<AppointmentSlot> calculateAvailableSlots(UUID lawyerId, LocalDate date, List<Appointment> appointments) {
        return List.of();
    }
}