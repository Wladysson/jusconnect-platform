package com.jusconnect.users.infrastructure.persistence.mapper;

import jakarta.enterprise.context.ApplicationScoped;

import com.jusconnect.users.domain.model.User;
import com.jusconnect.users.domain.model.LawyerProfile;
import com.jusconnect.users.domain.model.ClientProfile;
import com.jusconnect.users.domain.model.Document;

import com.jusconnect.users.infrastructure.persistence.entity.*;

@ApplicationScoped
public class UserPersistenceMapper {

    // ==================================================
    // USER
    // ==================================================

    public User toDomain(UserEntity entity) {

        if (entity == null) return null;

        User user = new User();

        user.setId(entity.id);
        user.setName(entity.name);
        user.setEmail(entity.email);
        user.setPasswordHash(entity.passwordHash);

        user.setStatus(
                com.jusconnect.users.domain.enums.UserStatus.valueOf(entity.status)
        );

        user.setType(
                com.jusconnect.users.domain.enums.UserType.valueOf(entity.type)
        );

        user.setCreatedAt(entity.createdAt);
        user.setUpdatedAt(entity.updatedAt);

        return user;
    }

    public UserEntity toEntity(User user) {

        if (user == null) return null;

        UserEntity entity = new UserEntity();

        entity.id = user.getId();
        entity.name = user.getName();
        entity.email = user.getEmail();
        entity.passwordHash = user.getPasswordHash();

        entity.status = user.getStatus().name();
        entity.type = user.getType().name();

        entity.createdAt = user.getCreatedAt();
        entity.updatedAt = user.getUpdatedAt();

        return entity;
    }

    // ==================================================
    // LAWYER PROFILE
    // ==================================================

    public LawyerProfile toDomain(LawyerProfileEntity entity) {

        if (entity == null) return null;

        LawyerProfile profile = new LawyerProfile();

        profile.setId(entity.id);
        profile.setUserId(entity.userId);
        profile.setOabNumber(entity.oabNumber);
        profile.setState(entity.state);
        profile.setSpecialty(entity.specialty);
        profile.setBio(entity.bio);

        return profile;
    }

    public LawyerProfileEntity toEntity(LawyerProfile profile) {

        if (profile == null) return null;

        LawyerProfileEntity entity = new LawyerProfileEntity();

        entity.id = profile.getId();
        entity.userId = profile.getUserId();
        entity.oabNumber = profile.getOabNumber();
        entity.state = profile.getState();
        entity.specialty = profile.getSpecialty();
        entity.bio = profile.getBio();

        return entity;
    }

    // ==================================================
    // CLIENT PROFILE
    // ==================================================

    public ClientProfile toDomain(ClientProfileEntity entity) {

        if (entity == null) return null;

        ClientProfile profile = new ClientProfile();

        profile.setId(entity.id);
        profile.setUserId(entity.userId);
        profile.setCpf(entity.cpf);
        profile.setPhone(entity.phone);

        return profile;
    }

    public ClientProfileEntity toEntity(ClientProfile profile) {

        if (profile == null) return null;

        ClientProfileEntity entity = new ClientProfileEntity();

        entity.id = profile.getId();
        entity.userId = profile.getUserId();
        entity.cpf = profile.getCpf();
        entity.phone = profile.getPhone();

        return entity;
    }

    // ==================================================
    // DOCUMENT
    // ==================================================

    public Document toDomain(DocumentEntity entity) {

        if (entity == null) return null;

        Document doc = new Document();

        doc.setId(entity.id);
        doc.setUserId(entity.userId);
        doc.setType(
                com.jusconnect.users.domain.enums.DocumentType.valueOf(entity.type)
        );
        doc.setFileUrl(entity.fileUrl);
        doc.setVerified(entity.verified);
        doc.setCreatedAt(entity.createdAt);

        return doc;
    }

    public DocumentEntity toEntity(Document doc) {

        if (doc == null) return null;

        DocumentEntity entity = new DocumentEntity();

        entity.id = doc.getId();
        entity.userId = doc.getUserId();
        entity.type = doc.getType().name();
        entity.fileUrl = doc.getFileUrl();
        entity.verified = doc.isVerified();
        entity.createdAt = doc.getCreatedAt();

        return entity;
    }
}