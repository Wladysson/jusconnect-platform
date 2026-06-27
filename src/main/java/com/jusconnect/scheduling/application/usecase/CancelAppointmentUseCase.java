package com.jusconnect.scheduling.application.usecase;

import com.jusconnect.scheduling.domain.model.Appointment;
import com.jusconnect.scheduling.domain.repository.AppointmentRepository;
import com.jusconnect.scheduling.domain.service.SchedulingDomainService;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class CancelAppointmentUseCase {

    private final AppointmentRepository appointmentRepository;

    private final SchedulingDomainService schedulingDomainService;

    public CancelAppointmentUseCase(
            AppointmentRepository appointmentRepository,
            SchedulingDomainService schedulingDomainService
    ) {
        this.appointmentRepository = appointmentRepository;
        this.schedulingDomainService = schedulingDomainService;
    }

    public Optional<Appointment> execute(
            UUID appointmentId,
            String reason
    ) {

        Optional<Appointment> appointmentOptional =
                appointmentRepository.findById(
                        appointmentId
                );

        if (appointmentOptional.isEmpty()) {
            return Optional.empty();
        }

        Appointment appointment =
                appointmentOptional.get();

        schedulingDomainService.validateCancellation(
                appointment
        );

        appointment.cancel();

        Appointment updated =
                appointmentRepository.update(
                        appointment
                );

        return Optional.of(
                updated
        );
    }

}