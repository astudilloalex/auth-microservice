package com.alexastudillo.application.response;

public class ApiResponse<T> {

    private int statusCode;
    private String code;
    private T data;

    public ApiResponse(int statusCode, String code, T data) {
        this.statusCode = statusCode;
        this.code = code;
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

