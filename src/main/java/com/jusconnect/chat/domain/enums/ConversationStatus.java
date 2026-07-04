package com.jusconnect.chat.domain.enums;

// Representa o estado atual de uma conversa
public enum ConversationStatus {

    // Conversa disponível para interação
    ACTIVE,

    // Conversa arquivada pelo usuário
    ARCHIVED,

    // Conversa encerrada definitivamente
    CLOSED,

    // Conversa bloqueada por alguma restrição
    BLOCKED

}