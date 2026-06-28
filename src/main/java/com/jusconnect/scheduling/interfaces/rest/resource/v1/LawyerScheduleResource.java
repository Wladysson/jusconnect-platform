package com.jusconnect.scheduling.interfaces.rest.resource.v1;

import com.jusconnect.scheduling.application.dto.response.AppointmentResponse;
import com.jusconnect.scheduling.application.mapper.AppointmentMapper;
import com.jusconnect.scheduling.application.service.SchedulingApplicationService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Path("/api/v1/lawyers/{lawyerId}/schedule")
@Produces(MediaType.APPLICATION_JSON)
public class LawyerScheduleResource {

    @Inject
    SchedulingApplicationService schedulingApplicationService;

    @GET
    public Response getSchedule(

            @PathParam("lawyerId")
            UUID lawyerId,

            @QueryParam("status")
            String status,

            @QueryParam("appointmentType")
            String appointmentType,

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

        return Response.ok(response)
                .build();
    }

}