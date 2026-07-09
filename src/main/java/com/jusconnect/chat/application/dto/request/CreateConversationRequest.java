package com.jusconnect.chat.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.UUID;

public class CreateConversationRequest {

    // Nome da conversa
    @NotBlank(message = "O nome da conversa é obrigatório.")
    @Size(max = 150, message = "O nome da conversa deve possuir no máximo 150 caracteres.")
    private String name;

    // Lista de participantes da conversa
    @NotEmpty(message = "A conversa deve possuir pelo menos um participante.")
    private List<UUID> participantIds;

    // Tipo da conversa (PRIVATE, GROUP...)
    @NotBlank(message = "O tipo da conversa é obrigatório.")
    private String conversationType;

    // Identificador do usuário criador da conversa
    private UUID createdBy;

    // Descrição da conversa
    @Size(max = 500, message = "A descrição deve possuir no máximo 500 caracteres.")
    private String description;

    public CreateConversationRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UUID> getParticipantIds() {
        return participantIds;
    }

    public void setParticipantIds(List<UUID> participantIds) {
        this.participantIds = participantIds;
    }

    public String getConversationType() {
        return conversationType;
    }

    public void setConversationType(String conversationType) {
        this.conversationType = conversationType;
    }

    public UUID getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UUID createdBy) {
        this.createdBy = createdBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}