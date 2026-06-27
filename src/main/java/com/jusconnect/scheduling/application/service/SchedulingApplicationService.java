package com.jusconnect.scheduling.application.service;

import com.jusconnect.scheduling.application.usecase.CancelAppointmentUseCase;
import com.jusconnect.scheduling.application.usecase.CreateAppointmentUseCase;
import com.jusconnect.scheduling.application.usecase.FindAvailableSlotsUseCase;
import com.jusconnect.scheduling.application.usecase.GetAppointmentByIdUseCase;
import com.jusconnect.scheduling.application.usecase.RescheduleAppointmentUseCase;
import com.jusconnect.scheduling.application.usecase.SearchAppointmentsUseCase;
import com.jusconnect.scheduling.domain.model.Appointment;
import com.jusconnect.scheduling.domain.model.AppointmentSlot;
import java.time.LocalDateTime;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class SchedulingApplicationService {

    @Inject
    CreateAppointmentUseCase createAppointmentUseCase;

    @Inject
    GetAppointmentByIdUseCase getAppointmentByIdUseCase;

    @Inject
    SearchAppointmentsUseCase searchAppointmentsUseCase;

    @Inject
    RescheduleAppointmentUseCase rescheduleAppointmentUseCase;

    @Inject
    CancelAppointmentUseCase cancelAppointmentUseCase;

    @Inject
    FindAvailableSlotsUseCase findAvailableSlotsUseCase;

    public Appointment create(
            Appointment appointment
    ) {
        return createAppointmentUseCase.execute(
                appointment
        );
    }

    public Optional<Appointment> findById(
            UUID appointmentId
    ) {
        return getAppointmentByIdUseCase.execute(
                appointmentId
        );
    }

    public List<Appointment> search(
            String status,
            String appointmentType,
            UUID lawyerId,
            UUID clientId
    ) {
        return searchAppointmentsUseCase.execute(
                status,
                lawyerId,
                clientId,
                appointmentType
        );
    }

    public Optional<Appointment> reschedule(
            UUID appointmentId,
            LocalDateTime newDateTime
    ) {
        return rescheduleAppointmentUseCase.execute(
                appointmentId,
                newDateTime
        );
    }

    public void cancel(
            UUID appointmentId,
            String reason
    ) {
        cancelAppointmentUseCase.execute(
                appointmentId,
                reason
        );
    }

    public List<AppointmentSlot> findAvailableSlots(
            UUID lawyerId,
            LocalDate date
    ) {
        return findAvailableSlotsUseCase.execute(
                lawyerId,
                date
        );
    }
}