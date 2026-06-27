package com.jusconnect.scheduling.application.usecase;

import com.jusconnect.scheduling.domain.model.Appointment;
import com.jusconnect.scheduling.domain.model.AppointmentSlot;
import com.jusconnect.scheduling.domain.repository.AppointmentRepository;
import com.jusconnect.scheduling.domain.service.SchedulingDomainService;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class FindAvailableSlotsUseCase {

    private final AppointmentRepository appointmentRepository;
    private final SchedulingDomainService schedulingDomainService;

    public FindAvailableSlotsUseCase(
            AppointmentRepository appointmentRepository,
            SchedulingDomainService schedulingDomainService
    ) {
        this.appointmentRepository = appointmentRepository;
        this.schedulingDomainService = schedulingDomainService;
    }

    public List<AppointmentSlot> execute(UUID lawyerId, LocalDate date) {

        // repository retorna APPOINTMENTS
        List<Appointment> appointments =
                appointmentRepository.findOccupiedSlots(lawyerId, date);

        //service converte para slots disponíveis
        return schedulingDomainService.calculateAvailableSlots(
                lawyerId,
                date,
                appointments
        );
    }
}