package com.alexastudillo.application.response;

public enum ResponseCode {
    EMAIL_ALREADY_IN_USE("email-already-in-use"),
    FORBIDDEN("forbidden"),
    NOT_FOUND("not-found"),
    SUCCESSFUL("successful"),
    SERVER_ERROR("server-error"),
    UNAUTHORIZED("unauthorized"),
    VALIDATION_ERROR("validation-error");

    private final String code;

    private ResponseCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
