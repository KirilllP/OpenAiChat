package com.example.demo;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class OpenAiChatController {

    OpenAiChatService chatService;

    //for some reason this method is never called
    @MessageMapping("/hello")
    public ChatMessageDTO send(@Payload ChatMessageDTO message) throws Exception {
        return chatService.processRequest(message);
    }
}