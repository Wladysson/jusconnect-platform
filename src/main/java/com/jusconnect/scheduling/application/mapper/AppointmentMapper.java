package com.jusconnect.scheduling.application.mapper;

import com.jusconnect.scheduling.application.dto.request.CreateAppointmentRequest;
import com.jusconnect.scheduling.application.dto.response.AppointmentDetailResponse;
import com.jusconnect.scheduling.application.dto.response.AppointmentResponse;
import com.jusconnect.scheduling.domain.enums.AppointmentStatus;
import com.jusconnect.scheduling.domain.enums.AppointmentType;
import com.jusconnect.scheduling.domain.enums.MeetingPlatform;
import com.jusconnect.scheduling.domain.model.Appointment;

public final class AppointmentMapper {

    private AppointmentMapper() {
    }

    public static Appointment toDomain(
            CreateAppointmentRequest request
    ) {

        Appointment appointment = new Appointment();

        appointment.setTriageId(
                request.getTriageId()
        );

        appointment.setLawyerId(
                request.getLawyerId()
        );

        appointment.setClientId(
                request.getClientId()
        );

        appointment.setScheduledAt(
                request.getScheduledAt()
        );

        if (request.getAppointmentType() != null) {
            appointment.setAppointmentType(
                    AppointmentType.valueOf(
                            request.getAppointmentType()
                    )
            );
        }

        if (request.getMeetingPlatform() != null) {
            appointment.setMeetingPlatform(
                    MeetingPlatform.valueOf(
                            request.getMeetingPlatform()
                    )
            );
        }

        appointment.setNotes(
                request.getNotes()
        );

        appointment.setStatus(
                AppointmentStatus.PENDING
        );

        return appointment;
    }

    public static AppointmentResponse toResponse(
            Appointment appointment
    ) {

        AppointmentResponse response =
                new AppointmentResponse();

        response.setId(
                appointment.getId()
        );

        response.setTriageId(
                appointment.getTriageId()
        );

        response.setLawyerId(
                appointment.getLawyerId()
        );

        response.setClientId(
                appointment.getClientId()
        );

        response.setScheduledAt(
                appointment.getScheduledAt()
        );

        response.setAppointmentType(
                appointment.getAppointmentType() != null
                        ? appointment.getAppointmentType().name()
                        : null
        );

        response.setMeetingPlatform(
                appointment.getMeetingPlatform() != null
                        ? appointment.getMeetingPlatform().name()
                        : null
        );

        response.setStatus(
                appointment.getStatus() != null
                        ? appointment.getStatus().name()
                        : null
        );

        return response;
    }

    public static AppointmentDetailResponse toDetailResponse(
            Appointment appointment
    ) {

        AppointmentDetailResponse response =
                new AppointmentDetailResponse();

        response.setId(
                appointment.getId()
        );

        response.setTriageId(
                appointment.getTriageId()
        );

        response.setLawyerId(
                appointment.getLawyerId()
        );

        response.setClientId(
                appointment.getClientId()
        );

        response.setScheduledAt(
                appointment.getScheduledAt()
        );

        response.setAppointmentType(
                appointment.getAppointmentType() != null
                        ? appointment.getAppointmentType().name()
                        : null
        );

        response.setMeetingPlatform(
                appointment.getMeetingPlatform() != null
                        ? appointment.getMeetingPlatform().name()
                        : null
        );

        response.setStatus(
                appointment.getStatus() != null
                        ? appointment.getStatus().name()
                        : null
        );

        response.setNotes(
                appointment.getNotes()
        );

        response.setCreatedAt(
                appointment.getCreatedAt()
        );

        response.setUpdatedAt(
                appointment.getUpdatedAt()
        );

        return response;
    }
}