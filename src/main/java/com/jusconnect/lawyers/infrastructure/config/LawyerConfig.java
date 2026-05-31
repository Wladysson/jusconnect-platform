package com.jusconnect.lawyers.infrastructure.config;

import jakarta.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class LawyerConfig {

    @ConfigProperty(
            name = "lawyer.review.max-rating",
            defaultValue = "5"
    )
    int maxReviewRating;

    @ConfigProperty(
            name = "lawyer.search.default-page-size",
            defaultValue = "10"
    )
    int defaultPageSize;

    @ConfigProperty(
            name = "lawyer.availability.enabled",
            defaultValue = "true"
    )
    boolean availabilityEnabled;

    public int getMaxReviewRating() {
        return maxReviewRating;
    }

    public int getDefaultPageSize() {
        return defaultPageSize;
    }

    public boolean isAvailabilityEnabled() {
        return availabilityEnabled;
    }
}