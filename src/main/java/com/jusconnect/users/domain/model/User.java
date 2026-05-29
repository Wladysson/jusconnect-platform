package com.jusconnect.users.domain.model;

import com.jusconnect.users.domain.enums.UserStatus;
import com.jusconnect.users.domain.enums.UserType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {

    private UUID id;
    private String name;
    private String email;

    private UserStatus status;

    private ContactInfo contactInfo;
    private Address address;

    private List<Document> documents = new ArrayList<>();

    private LawyerProfile lawyerProfile;
    private ClientProfile clientProfile;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private UserType type;

    public User() {
    }

    public void activate() {
        this.status = UserStatus.ACTIVE;
    }

    public void deactivate() {
        this.status = UserStatus.INACTIVE;
    }

    public void suspend() {
        this.status = UserStatus.SUSPENDED;
    }

    public void addDocument(Document document) {
        this.documents.add(document);
    }

    public boolean isActive() {
        return status == UserStatus.ACTIVE;
    }

    // Getters & Setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public Address getAddress() {
        return address;
    }

    public UserType getType() { return type; }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public LawyerProfile getLawyerProfile() {
        return lawyerProfile;
    }

    public void setLawyerProfile(LawyerProfile lawyerProfile) {
        this.lawyerProfile = lawyerProfile;
    }

    public ClientProfile getClientProfile() {
        return clientProfile;
    }

    public void setClientProfile(ClientProfile clientProfile) {
        this.clientProfile = clientProfile;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setType(UserType type) { this.type = type; }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setPasswordHash(String password) {
    }
}