package com.jusconnect.infrastructure.clients;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.Map;

@Path("/api/v1/ai")
@RegisterRestClient(configKey = "ai-service")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface AiServiceClient {

    @POST
    @Path("/triage")
    Map<String, Object> analyzeCase(
            Map<String, Object> request
    );
}