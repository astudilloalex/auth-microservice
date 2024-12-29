package com.alexastudillo.presentation.rest.mappers;

import com.alexastudillo.application.response.ResponseCode;
import com.alexastudillo.domain.exceptions.AuthException;
import com.alexastudillo.presentation.rest.responses.ErrorResponse;

import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GlobalExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable exception) {
        ErrorResponse error = new ErrorResponse(
                Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),
                ResponseCode.SERVER_ERROR.getCode(),
                exception.getMessage() != null ? exception.getMessage() : "An unexpected error occurred.");
        if (exception instanceof NotFoundException) {
            error = new ErrorResponse(
                    Response.Status.NOT_FOUND.getStatusCode(),
                    ResponseCode.NOT_FOUND.getCode(),
                    exception.getMessage() != null ? exception.getMessage() : "An unexpected error occurred.");
        }
        if(exception instanceof AuthException){
            AuthException authException = (AuthException) exception;
            error = new ErrorResponse(
                    Response.Status.BAD_REQUEST.getStatusCode(),
                    authException.getCode().getCode(),
                    exception.getMessage() != null ? exception.getMessage() : "An unexpected error occurred.");
        }
        return Response.status(error.getStatusCode())
                .entity(error)
                .build();
    }
}
