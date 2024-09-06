package com.example.demo;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

@Controller
public class OpenAiChatController {

    OpenAiChatService chatService;

    @MessageMapping("/app")
    public ChatMessageDTO send(@Payload ChatMessageDTO message) throws Exception {
        return chatService.processRequest(message);
    }
}