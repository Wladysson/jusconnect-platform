package com.jusconnect.scheduling.application.usecase;

import com.jusconnect.scheduling.domain.model.Appointment;
import com.jusconnect.scheduling.domain.repository.AppointmentRepository;
import com.jusconnect.scheduling.domain.service.SchedulingDomainService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CreateAppointmentUseCase {

    private final AppointmentRepository appointmentRepository;

    private final SchedulingDomainService schedulingDomainService;

    public CreateAppointmentUseCase(
            AppointmentRepository appointmentRepository,
            SchedulingDomainService schedulingDomainService
    ) {
        this.appointmentRepository = appointmentRepository;
        this.schedulingDomainService = schedulingDomainService;
    }

    public Appointment execute(
            Appointment appointment
    ) {

        schedulingDomainService.validateAppointment(
                appointment
        );

        schedulingDomainService.validateAvailability(
                appointment
        );

        appointment.setStatus(
                schedulingDomainService.initialStatus()
        );

        return appointmentRepository.save(
                appointment
        );
    }

}