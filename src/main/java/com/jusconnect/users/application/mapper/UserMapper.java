package com.jusconnect.users.application.mapper;

import jakarta.enterprise.context.ApplicationScoped;

import com.jusconnect.users.domain.model.*;

import com.jusconnect.users.application.dto.response.*;

import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;

@ApplicationScoped
public class UserMapper {

    public UserResponse toResponse(User user) {

        if (user == null) return null;

        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                String.valueOf(user.getStatus()),
                String.valueOf(user.getType()),
                user.getCreatedAt()
        );
    }

    public UserSummaryResponse toSummary(User user) {

        if (user == null) return null;

        return new UserSummaryResponse(
                user.getId(),
                user.getName(),
                String.valueOf(user.getType())
        );
    }

    public LawyerProfileResponse toResponse(LawyerProfile profile) {

        if (profile == null) return null;

        return new LawyerProfileResponse(
                profile.getId(),
                profile.getOabNumber(),
                profile.getState(),
                profile.getSpecialty(),
                profile.getBio()
        );
    }

    public ClientProfileResponse toResponse(ClientProfile profile) {

        if (profile == null) return null;

        return new ClientProfileResponse(
                profile.getId(),
                profile.getCpf(),
                profile.getPhone()
        );
    }

    public DocumentResponse toResponse(Document doc) {

        if (doc == null) return null;

        return new DocumentResponse(
                doc.getId(),
                String.valueOf(doc.getType()),
                doc.getFileUrl(),
                doc.isVerified(),
                doc.getCreatedAt()
        );
    }

    public List<DocumentResponse> toDocumentList(List<Document> documents) {

        if (documents == null || documents.isEmpty()) {
            return Collections.emptyList();
        }

        return documents.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}