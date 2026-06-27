package com.jusconnect.scheduling.application.usecase;

import com.jusconnect.scheduling.domain.model.Appointment;
import com.jusconnect.scheduling.domain.repository.AppointmentRepository;
import com.jusconnect.scheduling.domain.service.SchedulingDomainService;

import java.util.Optional;
import java.util.UUID;

public class CompleteAppointmentUseCase {

    private final AppointmentRepository appointmentRepository;

    private final SchedulingDomainService schedulingDomainService;

    public CompleteAppointmentUseCase(
            AppointmentRepository appointmentRepository,
            SchedulingDomainService schedulingDomainService
    ) {
        this.appointmentRepository = appointmentRepository;
        this.schedulingDomainService = schedulingDomainService;
    }

    public Optional<Appointment> execute(
            UUID appointmentId
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

        schedulingDomainService.validateCompletion(
                appointment
        );

        appointment.complete();

        Appointment updated =
                appointmentRepository.update(
                        appointment
                );

        return Optional.of(
                updated
        );
    }

}