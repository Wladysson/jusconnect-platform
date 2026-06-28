package com.jusconnect.scheduling.interfaces.rest.resource.v1;

import com.jusconnect.scheduling.application.dto.request.CreateAppointmentRequest;
import com.jusconnect.scheduling.application.dto.request.CancelAppointmentRequest;
import com.jusconnect.scheduling.application.dto.request.RescheduleAppointmentRequest;
import com.jusconnect.scheduling.application.dto.response.AppointmentResponse;
import com.jusconnect.scheduling.application.mapper.AppointmentMapper;
import com.jusconnect.scheduling.application.service.SchedulingApplicationService;
import com.jusconnect.scheduling.domain.model.Appointment;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Path("/api/v1/appointments")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AppointmentResource {

    @Inject
    SchedulingApplicationService schedulingApplicationService;

    @POST
    public Response create(
            CreateAppointmentRequest request
    ) {

        Appointment appointment =
                AppointmentMapper.toDomain(request);

        Appointment created =
                schedulingApplicationService.create(
                        appointment
                );

        return Response.status(Response.Status.CREATED)
                .entity(
                        AppointmentMapper.toResponse(created)
                )
                .build();
    }

    @GET
    @Path("/{appointmentId}")
    public Response findById(
            @PathParam("appointmentId")
            UUID appointmentId
    ) {

        return schedulingApplicationService
                .findById(appointmentId)
                .map(AppointmentMapper::toResponse)
                .map(Response::ok)
                .orElse(Response.status(Response.Status.NOT_FOUND))
                .build();
    }

    @GET
    public Response search(

            @QueryParam("status")
            String status,

            @QueryParam("appointmentType")
            String appointmentType,

            @QueryParam("lawyerId")
            UUID lawyerId,

            @QueryParam("clientId")
            UUID clientId
    ) {

        List<AppointmentResponse> response =
                schedulingApplicationService
                        .search(
                                status,
                                appointmentType,
                                lawyerId,
                                clientId
                        )
                        .stream()
                        .map(AppointmentMapper::toResponse)
                        .collect(Collectors.toList());

        return Response.ok(response).build();
    }

    @PUT
    @Path("/{appointmentId}/reschedule")
    public Response reschedule(

            @PathParam("appointmentId")
            UUID appointmentId,

            RescheduleAppointmentRequest request
    ) {

        return schedulingApplicationService
                .reschedule(
                        appointmentId,
                        request.getNewDateTime()
                )
                .map(AppointmentMapper::toResponse)
                .map(Response::ok)
                .orElse(Response.status(Response.Status.NOT_FOUND))
                .build();
    }

    @PUT
    @Path("/{appointmentId}/cancel")
    public Response cancel(

            @PathParam("appointmentId")
            UUID appointmentId,

            CancelAppointmentRequest request
    ) {

        schedulingApplicationService.cancel(
                appointmentId,
                request.getReason()
        );

        return Response.noContent().build();
    }

}