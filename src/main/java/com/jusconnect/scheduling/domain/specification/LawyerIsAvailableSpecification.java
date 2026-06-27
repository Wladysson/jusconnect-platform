package com.jusconnect.scheduling.domain.specification;

import com.jusconnect.scheduling.domain.model.Appointment;

import java.time.LocalDateTime;
import java.util.List;

public class LawyerIsAvailableSpecification {

    public boolean isSatisfiedBy(
            Appointment newAppointment,
            List<Appointment> existingAppointments
    ) {

        if (newAppointment == null) {
            return false;
        }

        if (newAppointment.getLawyerId() == null) {
            return false;
        }

        if (newAppointment.getScheduledAt() == null) {
            return false;
        }

        if (existingAppointments == null || existingAppointments.isEmpty()) {
            return true;
        }

        LocalDateTime newStart =
                newAppointment.getScheduledAt();

        return existingAppointments.stream()
                .noneMatch(existing ->
                        isOverlapping(
                                newStart,
                                existing.getScheduledAt()
                        )
                );
    }

    private boolean isOverlapping(
            LocalDateTime newDate,
            LocalDateTime existingDate
    ) {

        if (existingDate == null) {
            return false;
        }

        // regra simples: mesmo horário já bloqueia conflito
        return newDate.equals(existingDate);

    }

}