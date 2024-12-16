package com.alexastudillo.application.response;

public enum ResponseCode {
    SUCCESSFUL("successful"),
    SERVER_ERROR("server-error"),
    VALIDATION_ERROR("validation-error"),
    NOT_FOUND("not-found"),
    UNAUTHORIZED("unauthorized"),
    FORBIDDEN("forbidden");

    private final String code;

    private ResponseCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
