package com.jusconnect.lawyers.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public class LawyerStatistics {

    private UUID lawyerId;

    private Integer totalReviews;
    private BigDecimal averageRating;
    private Integer completedCases;
    private Integer responseTime;

    public LawyerStatistics() {
    }

    public UUID getLawyerId() {
        return lawyerId;
    }

    public void setLawyerId(UUID lawyerId) {
        this.lawyerId = lawyerId;
    }

    public Integer getTotalReviews() {
        return totalReviews;
    }

    public void setTotalReviews(Integer totalReviews) {
        this.totalReviews = totalReviews;
    }

    public BigDecimal getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(BigDecimal averageRating) {
        this.averageRating = averageRating;
    }

    public Integer getCompletedCases() {
        return completedCases;
    }

    public void setCompletedCases(Integer completedCases) {
        this.completedCases = completedCases;
    }

    public Integer getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Integer responseTime) {
        this.responseTime = responseTime;
    }
}