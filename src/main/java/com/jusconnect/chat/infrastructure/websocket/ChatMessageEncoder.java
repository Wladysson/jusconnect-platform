package com.jusconnect.chat.infrastructure.websocket;

import jakarta.websocket.Encoder;
import jakarta.websocket.EndpointConfig;

public class ChatMessageEncoder implements Encoder.Text<String> {

    @Override
    public String encode(String message) {

        // Retorna a mensagem que será enviada ao cliente
        return message;

    }

    @Override
    public void init(EndpointConfig config) {

        // Inicialização do encoder
    }

    @Override
    public void destroy() {

        // Liberação de recursos
    }

}