package com.example.demo;


public interface OpenAiChatService {

    ThreadDto createThread(ThreadMessageDto messageDto);

    String sendMessage(ThreadMessageDto messageDto);
}
