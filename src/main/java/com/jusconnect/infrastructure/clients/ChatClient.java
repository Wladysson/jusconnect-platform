package com.jusconnect.infrastructure.clients;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.Map;

@Path("/api/v1/chat")
@RegisterRestClient(configKey = "chat-service")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface ChatClient {

    @POST
    @Path("/message")
    Map<String, Object> sendMessage(
            Map<String, Object> request
    );
}