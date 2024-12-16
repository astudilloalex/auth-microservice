package com.alexastudillo.presentation.controller;

import com.alexastudillo.application.usecase.GetAllPermissionsUseCase;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/v1/permission")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PermissionController {
    @Inject
    private GetAllPermissionsUseCase getAllPermissionsUseCase;

    @GET
    @Path("/all")
    public Response all(@QueryParam("active") Boolean active, @QueryParam("last_code") String lastCode,
            @DefaultValue("10") @QueryParam("active") int size) {
        return Response.ok(getAllPermissionsUseCase.execute(lastCode, size, active)).build();
    }
}
