package com.jusconnect.chat.domain.enums;

// Representa o ciclo de vida de uma mensagem
public enum MessageStatus {

    // Mensagem criada
    CREATED,

    // Mensagem enviada
    SENT,

    // Mensagem entregue ao destinatário
    DELIVERED,

    // Mensagem visualizada
    READ,

    // Mensagem removida
    DELETED

}