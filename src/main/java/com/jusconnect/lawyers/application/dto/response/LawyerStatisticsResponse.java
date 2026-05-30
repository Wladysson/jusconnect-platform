package com.jusconnect.lawyers.application.dto.response;

import java.math.BigDecimal;
import java.util.UUID;

public class LawyerStatisticsResponse {

    private UUID lawyerId;
    private Integer totalReviews;
    private BigDecimal averageRating;
    private Integer completedCases;
    private Integer responseTime;

    public LawyerStatisticsResponse() {
    }

    public LawyerStatisticsResponse(
            UUID lawyerId,
            Integer totalReviews,
            BigDecimal averageRating,
            Integer completedCases,
            Integer responseTime
    ) {
        this.lawyerId = lawyerId;
        this.totalReviews = totalReviews;
        this.averageRating = averageRating;
        this.completedCases = completedCases;
        this.responseTime = responseTime;
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