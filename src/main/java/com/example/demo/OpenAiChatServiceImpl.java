package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class OpenAiChatServiceImpl implements OpenAiChatService {

    //here will be implemented all further logic
    @Override
    public ChatMessageDTO processRequest(ChatMessageDTO chatMessageDTO) {
        return ChatMessageDTO.builder()
                .from("server")
                .message("hiii, mr" + chatMessageDTO.getFrom()).build();
    }
}
