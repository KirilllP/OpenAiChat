package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class OpenAiChatServiceImpl implements OpenAiChatService {

    @Override
    public ChatMessageDTO processRequest(ChatMessageDTO chatMessageDTO) {
        return new ChatMessageDTO("server", "hiii");
    }
}
