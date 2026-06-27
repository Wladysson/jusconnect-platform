package com.jusconnect.scheduling.domain.repository;

import com.jusconnect.scheduling.domain.model.Appointment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AppointmentRepository {

    Appointment save(
            Appointment appointment
    );

    Appointment update(
            Appointment appointment
    );

    Optional<Appointment> findById(
            UUID appointmentId
    );

    List<Appointment> search(
            String status,
            UUID lawyerId,
            UUID clientId,
            String appointmentType
    );

    List<Appointment> findConflicts(UUID lawyerId,
                                    LocalDateTime start,
                                    LocalDateTime end);

    List<Appointment> findOccupiedSlots(
            UUID lawyerId,
            LocalDate date
    );

    void delete(
            UUID appointmentId
    );

}