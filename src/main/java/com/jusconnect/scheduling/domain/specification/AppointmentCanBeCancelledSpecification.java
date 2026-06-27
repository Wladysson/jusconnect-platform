package com.jusconnect.scheduling.domain.specification;

import com.jusconnect.scheduling.domain.enums.AppointmentStatus;
import com.jusconnect.scheduling.domain.model.Appointment;

public class AppointmentCanBeCancelledSpecification {

    public boolean isSatisfiedBy(
            Appointment appointment
    ) {

        if (appointment == null) {
            return false;
        }

        return appointment.getStatus() != AppointmentStatus.CANCELLED
                && appointment.getStatus() != AppointmentStatus.COMPLETED;

    }

}