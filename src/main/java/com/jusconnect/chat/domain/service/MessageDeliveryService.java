package com.jusconnect.chat.domain.service;

import com.jusconnect.chat.domain.enums.MessageStatus;
import com.jusconnect.chat.domain.model.Message;

import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDateTime;
import java.util.UUID;

@ApplicationScoped
public class MessageDeliveryService {

    // Processa o envio da mensagem
    public void deliver(Message message) {

        message.setStatus(MessageStatus.SENT);
        message.setSentAt(LocalDateTime.now());

    }

    // Marca uma mensagem como lida
    public void markAsRead(Message message, UUID userId) {

        message.setStatus(MessageStatus.READ);
        message.setUpdatedAt(LocalDateTime.now());

    }

}