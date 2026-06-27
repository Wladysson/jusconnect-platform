package com.jusconnect.scheduling.domain.service;

import com.jusconnect.scheduling.domain.model.AppointmentSlot;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class SlotGenerationService {

    private static final LocalTime START_TIME =
            LocalTime.of(8, 0);

    private static final LocalTime END_TIME =
            LocalTime.of(18, 0);

    private static final int SLOT_DURATION_MINUTES = 30;

    public List<AppointmentSlot> generateAvailableSlots(
            UUID lawyerId,
            LocalDate date,
            List<AppointmentSlot> occupiedSlots
    ) {

        List<AppointmentSlot> availableSlots =
                new ArrayList<>();

        LocalTime currentTime =
                START_TIME;

        while (currentTime.isBefore(END_TIME)) {

            LocalTime endTime =
                    currentTime.plusMinutes(
                            SLOT_DURATION_MINUTES
                    );

            AppointmentSlot slot =
                    new AppointmentSlot();

            slot.setLawyerId(
                    lawyerId
            );

            slot.setDate(
                    date
            );

            slot.setStartTime(
                    currentTime
            );

            slot.setEndTime(
                    endTime
            );

            slot.setStartDateTime(
                    LocalDateTime.of(
                            date,
                            currentTime
                    )
            );

            slot.setEndDateTime(
                    LocalDateTime.of(
                            date,
                            endTime
                    )
            );

            slot.setAvailable(
                    !isOccupied(
                            slot,
                            occupiedSlots
                    )
            );

            if (slot.isAvailable()) {
                availableSlots.add(
                        slot
                );
            }

            currentTime =
                    endTime;
        }

        return availableSlots;
    }

    private boolean isOccupied(
            AppointmentSlot slot,
            List<AppointmentSlot> occupiedSlots
    ) {

        if (occupiedSlots == null ||
                occupiedSlots.isEmpty()) {
            return false;
        }

        return occupiedSlots.stream()
                .anyMatch(occupied ->
                        occupied.getStartDateTime().equals(
                                slot.getStartDateTime()
                        )
                );
    }

}