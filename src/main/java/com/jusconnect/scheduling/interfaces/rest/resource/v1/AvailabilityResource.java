package com.jusconnect.scheduling.interfaces.rest.resource.v1;

import com.jusconnect.scheduling.application.dto.response.AvailableSlotResponse;
import com.jusconnect.scheduling.application.service.SchedulingApplicationService;
import com.jusconnect.scheduling.domain.model.AppointmentSlot;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Path("/api/v1/availability")
@Produces(MediaType.APPLICATION_JSON)
public class AvailabilityResource {

    @Inject
    SchedulingApplicationService schedulingApplicationService;

    @GET
    public Response findAvailableSlots(

            @QueryParam("lawyerId")
            java.util.UUID lawyerId,

            @QueryParam("date")
            LocalDate date
    ) {

        List<AppointmentSlot> slots =
                schedulingApplicationService.findAvailableSlots(
                        lawyerId,
                        date
                );

        List<AvailableSlotResponse> response =
                slots.stream()
                        .map(this::toResponse)
                        .collect(Collectors.toList());

        return Response.ok(response)
                .build();
    }

    private AvailableSlotResponse toResponse(
            AppointmentSlot slot
    ) {

        AvailableSlotResponse response =
                new AvailableSlotResponse();

        response.setStartTime(
                slot.getStartTime()
        );

        response.setEndTime(
                slot.getEndTime()
        );

        response.setAvailable(
                slot.isAvailable()
        );

        return response;
    }

}