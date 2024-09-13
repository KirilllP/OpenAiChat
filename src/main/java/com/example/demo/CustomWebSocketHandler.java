package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

@AllArgsConstructor
public class CustomWebSocketHandler extends TextWebSocketHandler {

    private static ObjectMapper mapper = new ObjectMapper();
    private OpenAiChatService openAiChatService;

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws IOException {
        // Handle incoming messages here
        ChatMessageDTO receivedMessage = mapper.readValue((String) message.getPayload(), ChatMessageDTO.class);
        // Process the message and send a response if needed
        session.sendMessage(new TextMessage(openAiChatService.processRequest(receivedMessage).toString().getBytes()));
    }
}
