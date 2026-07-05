package com.jusconnect.chat.domain.model;

public class ConversationSettings {

    // Permite envio de mensagens
    private boolean allowMessages;

    // Permite envio de anexos
    private boolean allowAttachments;

    // Permite edição de mensagens
    private boolean allowMessageEdition;

    // Permite exclusão de mensagens
    private boolean allowMessageDeletion;

    // Notificações habilitadas
    private boolean notificationsEnabled;

    // Conversa privada
    private boolean privateConversation;

    public ConversationSettings() {
        this.allowMessages = true;
        this.allowAttachments = true;
        this.allowMessageEdition = true;
        this.allowMessageDeletion = false;
        this.notificationsEnabled = true;
        this.privateConversation = true;
    }

    public boolean isAllowMessages() {
        return allowMessages;
    }

    public void setAllowMessages(boolean allowMessages) {
        this.allowMessages = allowMessages;
    }

    public boolean isAllowAttachments() {
        return allowAttachments;
    }

    public void setAllowAttachments(boolean allowAttachments) {
        this.allowAttachments = allowAttachments;
    }

    public boolean isAllowMessageEdition() {
        return allowMessageEdition;
    }

    public void setAllowMessageEdition(boolean allowMessageEdition) {
        this.allowMessageEdition = allowMessageEdition;
    }

    public boolean isAllowMessageDeletion() {
        return allowMessageDeletion;
    }

    public void setAllowMessageDeletion(boolean allowMessageDeletion) {
        this.allowMessageDeletion = allowMessageDeletion;
    }

    public boolean isNotificationsEnabled() {
        return notificationsEnabled;
    }

    public void setNotificationsEnabled(boolean notificationsEnabled) {
        this.notificationsEnabled = notificationsEnabled;
    }

    public boolean isPrivateConversation() {
        return privateConversation;
    }

    public void setPrivateConversation(boolean privateConversation) {
        this.privateConversation = privateConversation;
    }
}