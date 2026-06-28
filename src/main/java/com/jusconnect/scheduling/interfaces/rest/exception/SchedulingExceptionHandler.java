package com.jusconnect.scheduling.interfaces.rest.exception;

import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Provider
public class SchedulingExceptionHandler implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(
            Exception exception
    ) {

        if (exception instanceof WebApplicationException webException) {
            return Response.status(webException.getResponse().getStatus())
                    .entity(buildResponse(
                            webException.getMessage(),
                            webException.getResponse().getStatus()
                    ))
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }

        if (exception instanceof ConstraintViolationException validationException) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(buildResponse(
                            validationException.getMessage(),
                            Response.Status.BAD_REQUEST.getStatusCode()
                    ))
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(buildResponse(
                        "Erro interno no serviço de agendamento.",
                        Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()
                ))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    private Map<String, Object> buildResponse(
            String message,
            int status
    ) {

        Map<String, Object> response = new HashMap<>();

        response.put("timestamp", LocalDateTime.now());
        response.put("status", status);
        response.put("message", message);

        return response;
    }

}