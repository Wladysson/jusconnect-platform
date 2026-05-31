package com.jusconnect.lawyers.infrastructure.persistence.mapper;

import jakarta.enterprise.context.ApplicationScoped;

import com.jusconnect.lawyers.domain.model.Lawyer;
import com.jusconnect.lawyers.domain.model.LawyerAvailability;
import com.jusconnect.lawyers.domain.model.LawyerReview;

import com.jusconnect.lawyers.domain.enums.LawyerLevel;
import com.jusconnect.lawyers.domain.enums.ReviewStatus;

import com.jusconnect.lawyers.infrastructure.persistence.entity.LawyerEntity;
import com.jusconnect.lawyers.infrastructure.persistence.entity.LawyerAvailabilityEntity;
import com.jusconnect.lawyers.infrastructure.persistence.entity.LawyerReviewEntity;

@ApplicationScoped
public class LawyerPersistenceMapper {

    public Lawyer toDomain(
            LawyerEntity entity
    ) {

        if (entity == null) {
            return null;
        }

        Lawyer lawyer =
                new Lawyer();

        lawyer.setId(entity.id);
        lawyer.setUserId(entity.userId);
        lawyer.setOabNumber(entity.oabNumber);
        lawyer.setStateBar(entity.stateBar);
        lawyer.setBio(entity.bio);

        if (entity.level != null) {
            lawyer.setLevel(
                    LawyerLevel.valueOf(
                            entity.level
                    )
            );
        }

        lawyer.setVerified(
                entity.verified
        );

        lawyer.setCreatedAt(
                entity.createdAt
        );

        lawyer.setUpdatedAt(
                entity.updatedAt
        );

        return lawyer;
    }

    public LawyerEntity toEntity(
            Lawyer lawyer
    ) {

        if (lawyer == null) {
            return null;
        }

        LawyerEntity entity =
                new LawyerEntity();

        entity.id =
                lawyer.getId();

        entity.userId =
                lawyer.getUserId();

        entity.oabNumber =
                lawyer.getOabNumber();

        entity.stateBar =
                lawyer.getStateBar();

        entity.bio =
                lawyer.getBio();

        entity.level =
                lawyer.getLevel() != null
                        ? lawyer.getLevel().name()
                        : null;

        entity.verified =
                lawyer.isVerified();

        entity.createdAt =
                lawyer.getCreatedAt();

        entity.updatedAt =
                lawyer.getUpdatedAt();

        return entity;
    }

    public LawyerAvailability toDomain(
            LawyerAvailabilityEntity entity
    ) {

        if (entity == null) {
            return null;
        }

        LawyerAvailability availability =
                new LawyerAvailability();

        availability.setId(
                entity.id
        );

        availability.setLawyerId(
                entity.lawyerId
        );

        availability.setWeekday(
                entity.weekday
        );

        availability.setStartTime(
                entity.startTime
        );

        availability.setEndTime(
                entity.endTime
        );

        availability.setOnline(
                entity.online
        );

        availability.setActive(
                entity.active
        );

        return availability;
    }

    public LawyerAvailabilityEntity toEntity(
            LawyerAvailability availability
    ) {

        if (availability == null) {
            return null;
        }

        LawyerAvailabilityEntity entity =
                new LawyerAvailabilityEntity();

        entity.id =
                availability.getId();

        entity.lawyerId =
                availability.getLawyerId();

        entity.weekday =
                availability.getWeekday();

        entity.startTime =
                availability.getStartTime();

        entity.endTime =
                availability.getEndTime();

        entity.online =
                availability.isOnline();

        entity.active =
                availability.isActive();

        return entity;
    }

    public LawyerReview toDomain(
            LawyerReviewEntity entity
    ) {

        if (entity == null) {
            return null;
        }

        LawyerReview review =
                new LawyerReview();

        review.setId(
                entity.id
        );

        review.setLawyerId(
                entity.lawyerId
        );

        review.setClientId(
                entity.clientId
        );

        review.setRating(
                entity.rating
        );

        review.setComment(
                entity.comment
        );

        if (entity.status != null) {
            review.setStatus(
                    ReviewStatus.valueOf(
                            entity.status
                    )
            );
        }

        review.setCreatedAt(
                entity.createdAt
        );

        return review;
    }

    public LawyerReviewEntity toEntity(
            LawyerReview review
    ) {

        if (review == null) {
            return null;
        }

        LawyerReviewEntity entity =
                new LawyerReviewEntity();

        entity.id =
                review.getId();

        entity.lawyerId =
                review.getLawyerId();

        entity.clientId =
                review.getClientId();

        entity.rating =
                review.getRating();

        entity.comment =
                review.getComment();

        entity.status =
                review.getStatus() != null
                        ? review.getStatus().name()
                        : null;

        entity.createdAt =
                review.getCreatedAt();

        return entity;
    }
}