package com.alexastudillo.presentation.controller;

import java.util.List;

import com.alexastudillo.application.response.ApiResponse;
import com.alexastudillo.application.response.ResponseCode;
import com.alexastudillo.application.response.ResponseManager;
import com.alexastudillo.application.usecase.GetAllProvidersUseCase;
import com.alexastudillo.domain.entity.Provider;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/v1/provider")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProviderController {
    @Inject
    private GetAllProvidersUseCase getAllProvidersUseCase;

    @Inject
    private ResponseManager responseManager;

    @GET
    @Path("/all")
    public Response getAllProviders(@QueryParam("active") Boolean active) {
        try {
            List<Provider> providers = getAllProvidersUseCase.execute(active);
            ApiResponse<List<Provider>> response = responseManager.success(providers);
            return Response.ok(response).build();
        } catch (Exception e) {
            ApiResponse<Void> errorResponse = responseManager.error(ResponseCode.SERVER_ERROR, 500);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorResponse).build();
        }
    }

}
