package com.alexastudillo.application.response;

import java.util.List;

public class PagedApiResponse<T> {
    private int statusCode;
    private String code;
    private boolean hasNext;
    private long totalRecords;
    private List<T> data;

    public PagedApiResponse(int statusCode, String code, boolean hasNext, long totalRecords, List<T> data) {
        this.statusCode = statusCode;
        this.code = code;
        this.hasNext = hasNext;
        this.totalRecords = totalRecords;
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

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

}
