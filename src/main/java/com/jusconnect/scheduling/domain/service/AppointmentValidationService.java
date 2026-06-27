package com.jusconnect.scheduling.domain.service;

import com.jusconnect.scheduling.domain.enums.AppointmentStatus;
import com.jusconnect.scheduling.domain.model.Appointment;

import java.time.LocalDateTime;

public class AppointmentValidationService {

    public void validateAppointment(
            Appointment appointment
    ) {

        if (appointment == null) {
            throw new IllegalArgumentException("Agendamento é obrigatório.");
        }

        if (appointment.getClientId() == null) {
            throw new IllegalArgumentException("Cliente é obrigatório.");
        }

        if (appointment.getAppointmentDateTime() == null) {
            throw new IllegalArgumentException("Data do agendamento é obrigatória.");
        }

        if (appointment.getScheduledAt().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException(
                    "Não é permitido agendar para uma data passada."
            );
        }

        if (appointment.getAppointmentType() == null) {
            throw new IllegalArgumentException("Tipo do agendamento é obrigatório.");
        }

    }

    public void validateReschedule(
            Appointment appointment,
            LocalDateTime newDateTime
    ) {

        if (appointment == null) {
            throw new IllegalArgumentException("Agendamento não encontrado.");
        }

        if (appointment.getStatus() == AppointmentStatus.CANCELLED) {
            throw new IllegalStateException("Não é possível reagendar um agendamento cancelado.");
        }

        if (appointment.getStatus() == AppointmentStatus.COMPLETED) {
            throw new IllegalStateException("Não é possível reagendar um agendamento concluído.");
        }

        if (newDateTime == null) {
            throw new IllegalArgumentException("Nova data é obrigatória.");
        }

        if (newDateTime.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Nova data deve ser futura.");
        }

    }

    public void validateCancellation(
            Appointment appointment
    ) {

        if (appointment == null) {
            throw new IllegalArgumentException("Agendamento não encontrado.");
        }

        if (appointment.getStatus() == AppointmentStatus.CANCELLED) {
            throw new IllegalStateException("Agendamento já cancelado.");
        }

        if (appointment.getStatus() == AppointmentStatus.COMPLETED) {
            throw new IllegalStateException("Não é possível cancelar um agendamento concluído.");
        }

    }

    public void validateConfirmation(
            Appointment appointment
    ) {

        if (appointment == null) {
            throw new IllegalArgumentException("Agendamento não encontrado.");
        }

        if (appointment.getStatus() != AppointmentStatus.PENDING) {
            throw new IllegalStateException("Somente agendamentos pendentes podem ser confirmados.");
        }

    }

    public void validateCompletion(
            Appointment appointment
    ) {

        if (appointment == null) {
            throw new IllegalArgumentException("Agendamento não encontrado.");
        }

        if (appointment.getStatus() != AppointmentStatus.CONFIRMED) {
            throw new IllegalStateException("Somente agendamentos confirmados podem ser concluídos.");
        }

    }

}