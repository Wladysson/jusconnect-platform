package com.jusconnect.shared.response;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorResponse {

    private String error;

    private String message;

    private Integer status;

    private List<String> details;

    private LocalDateTime timestamp;

    public ErrorResponse() {
        this.timestamp = LocalDateTime.now();
    }

    public ErrorResponse(
            String error,
            String message,
            Integer status,
            List<String> details
    ) {
        this.error = error;
        this.message = message;
        this.status = status;
        this.details = details;
        this.timestamp = LocalDateTime.now();
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public Integer getStatus() {
        return status;
    }

    public List<String> getDetails() {
        return details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setDetails(
            List<String> details
    ) {
        this.details = details;
    }

    public void setTimestamp(
            LocalDateTime timestamp
    ) {
        this.timestamp = timestamp;
    }
}