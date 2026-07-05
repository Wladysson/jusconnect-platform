package com.jusconnect.chat.domain.model;

import java.time.LocalDateTime;

public class MessageMetadata {

    // Endereço IP do remetente
    private String senderIp;

    // Dispositivo utilizado no envio
    private String device;

    // Sistema operacional do dispositivo
    private String operatingSystem;

    // Navegador ou aplicação utilizada
    private String client;

    // Indica se a mensagem foi editada
    private boolean edited;

    // Data da edição
    private LocalDateTime editedAt;

    // Indica se a mensagem foi removida
    private boolean deleted;

    // Data da remoção
    private LocalDateTime deletedAt;

    public MessageMetadata() {
        this.edited = false;
        this.deleted = false;
    }

    public String getSenderIp() {
        return senderIp;
    }

    public void setSenderIp(String senderIp) {
        this.senderIp = senderIp;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public boolean isEdited() {
        return edited;
    }

    public void setEdited(boolean edited) {
        this.edited = edited;
    }

    public LocalDateTime getEditedAt() {
        return editedAt;
    }

    public void setEditedAt(LocalDateTime editedAt) {
        this.editedAt = editedAt;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}