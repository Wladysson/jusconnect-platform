package com.jusconnect.shared.response;

import java.util.List;

public class PaginationResponse<T> {

    private List<T> content;

    private long totalElements;

    private int totalPages;

    private int currentPage;

    private int pageSize;

    public PaginationResponse() {
    }

    public PaginationResponse(
            List<T> content,
            long totalElements,
            int totalPages,
            int currentPage,
            int pageSize
    ) {
        this.content = content;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public List<T> getContent() {
        return content;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setContent(
            List<T> content
    ) {
        this.content = content;
    }

    public void setTotalElements(
            long totalElements
    ) {
        this.totalElements = totalElements;
    }

    public void setTotalPages(
            int totalPages
    ) {
        this.totalPages = totalPages;
    }

    public void setCurrentPage(
            int currentPage
    ) {
        this.currentPage = currentPage;
    }

    public void setPageSize(
            int pageSize
    ) {
        this.pageSize = pageSize;
    }
}