package com.jusconnect.scheduling.domain.service;

import com.jusconnect.scheduling.domain.enums.AppointmentStatus;
import com.jusconnect.scheduling.domain.model.Appointment;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class AvailabilityService {

    public void validateAvailability(
            Appointment appointment
    ) {

        if (appointment == null) {
            throw new IllegalArgumentException("Agendamento é obrigatório.");
        }

        if (appointment.getAppointmentDateTime() == null) {
            throw new IllegalArgumentException("Data do agendamento é obrigatória.");
        }

         //Futuramente:
         //Consultar agenda do advogado
         //Verificar conflitos de horário
         //Verificar expediente
         //Verificar feriados
         //Verificar bloqueios na agenda
         //Verificar duração da consulta

    }

    public void validateLawyerAssignment(
            Appointment appointment,
            UUID lawyerId
    ) {

        if (appointment == null) {
            throw new IllegalArgumentException("Agendamento não encontrado.");
        }

        if (lawyerId == null) {
            throw new IllegalArgumentException("Advogado é obrigatório.");
        }

        if (appointment.getStatus() == AppointmentStatus.CANCELLED) {
            throw new IllegalStateException(
                    "Não é possível atribuir advogado a um agendamento cancelado."
            );
        }

        if (appointment.getStatus() == AppointmentStatus.COMPLETED) {
            throw new IllegalStateException(
                    "Não é possível atribuir advogado a um agendamento concluído."
            );
        }
         //Futuramente:

         //Validar existência do advogado
         //Validar disponibilidade
         //Validar especialidade jurídica
         //Validar carga horária
         //Validar conflitos de agenda
         //Validar afastamentos/férias


    }

}