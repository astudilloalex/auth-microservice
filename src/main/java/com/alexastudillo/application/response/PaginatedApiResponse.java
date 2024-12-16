package com.alexastudillo.application.response;

import java.util.List;

public class PaginatedApiResponse<T> {
    private int statusCode;
    private String code;
    private long totalElements;
    private int totalPages;
    private int numberOfElements;
    private int pageNumber;
    private boolean last;
    private boolean first;
    private long offset;
    private List<T> data;

    public PaginatedApiResponse() {
    }

    public PaginatedApiResponse(long totalElements, int totalPages, int numberOfElements, int pageNumber, boolean last,
            boolean first, long offset, List<T> data, int statusCode, String code) {
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.numberOfElements = numberOfElements;
        this.pageNumber = pageNumber;
        this.last = last;
        this.first = first;
        this.offset = offset;
        this.data = data;
        this.code = code;
        this.statusCode = statusCode;
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

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public long getOffset() {
        return offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
