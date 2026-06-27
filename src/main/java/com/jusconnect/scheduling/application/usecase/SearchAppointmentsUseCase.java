package com.jusconnect.scheduling.application.usecase;

import com.jusconnect.scheduling.domain.model.Appointment;
import com.jusconnect.scheduling.domain.repository.AppointmentRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class SearchAppointmentsUseCase {

    private final AppointmentRepository appointmentRepository;

    public SearchAppointmentsUseCase(
            AppointmentRepository appointmentRepository
    ) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> execute(
            String status,
            UUID lawyerId,
            UUID clientId,
            String appointmentType
    ) {

        return appointmentRepository.search(
                status,
                lawyerId,
                clientId,
                appointmentType
        );
    }

}