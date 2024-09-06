package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class OpenAiChatServiceImpl implements OpenAiChatService {

    //here will be implemented all further logic after problem with controller will be solved
    @Override
    public ChatMessageDTO processRequest(ChatMessageDTO chatMessageDTO) {
        return new ChatMessageDTO("server", "hiii");
    }
}
