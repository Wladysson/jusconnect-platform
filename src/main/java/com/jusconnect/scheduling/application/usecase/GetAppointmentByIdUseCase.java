package com.jusconnect.scheduling.application.usecase;

import com.jusconnect.scheduling.domain.model.Appointment;
import com.jusconnect.scheduling.domain.repository.AppointmentRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class GetAppointmentByIdUseCase {

    private final AppointmentRepository appointmentRepository;

    public GetAppointmentByIdUseCase(
            AppointmentRepository appointmentRepository
    ) {
        this.appointmentRepository = appointmentRepository;
    }

    public Optional<Appointment> execute(
            UUID appointmentId
    ) {
        return appointmentRepository.findById(
                appointmentId
        );
    }

}