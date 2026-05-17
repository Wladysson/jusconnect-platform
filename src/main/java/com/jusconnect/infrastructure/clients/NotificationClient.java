package com.jusconnect.infrastructure.clients;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.Map;

@Path("/api/v1/notifications")
@RegisterRestClient(configKey = "notification-service")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface NotificationClient {

    @POST
    @Path("/send")
    void sendNotification(
            Map<String, Object> request
    );
}