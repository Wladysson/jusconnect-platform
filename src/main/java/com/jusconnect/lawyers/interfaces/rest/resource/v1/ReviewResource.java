package com.jusconnect.lawyers.interfaces.rest.resource.v1;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import io.quarkus.security.Authenticated;

import com.jusconnect.lawyers.application.dto.request.CreateReviewRequest;
import com.jusconnect.lawyers.application.dto.response.ReviewResponse;
import com.jusconnect.lawyers.application.mapper.LawyerMapper;
import com.jusconnect.lawyers.application.usecase.CreateReviewUseCase;

import com.jusconnect.lawyers.domain.model.LawyerReview;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.UUID;

@Path("/api/v1/lawyers/reviews")
@Tag(
        name = "Reviews",
        description = "Avaliações de advogados"
)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReviewResource {

    @Inject
    CreateReviewUseCase createReviewUseCase;

    @Inject
    LawyerMapper mapper;

    @POST
    @Path("/{lawyerId}")
    @Authenticated
    public Response create(
            @PathParam("lawyerId") UUID lawyerId,
            CreateReviewRequest request
    ) {

        LawyerReview review =
                createReviewUseCase.execute(
                        lawyerId,
                        request
                );

        ReviewResponse response =
                mapper.toResponse(review);

        return Response.status(
                        Response.Status.CREATED
                )
                .entity(response)
                .build();
    }
}