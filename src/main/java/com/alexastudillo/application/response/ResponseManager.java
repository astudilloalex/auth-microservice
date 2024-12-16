package com.alexastudillo.application.response;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ResponseManager {

    public <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(200, ResponseCode.SUCCESSFUL.getCode(), data);
    }

    public ApiResponse<Void> success() {
        return new ApiResponse<>(200, ResponseCode.SUCCESSFUL.getCode(), null);
    }

    public ApiResponse<Void> error(ResponseCode errorCode, int statusCode) {
        return new ApiResponse<>(statusCode, errorCode.getCode(), null);
    }

    public <T> ApiResponse<T> customResponse(int statusCode, ResponseCode code, T data) {
        return new ApiResponse<>(statusCode, code.getCode(), data);
    }

}
