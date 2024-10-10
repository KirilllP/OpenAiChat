package com.example.demo;

import io.github.sashirestela.openai.SimpleOpenAI;
import io.github.sashirestela.openai.domain.assistant.Thread;
import io.github.sashirestela.openai.domain.assistant.ThreadMessageRequest;
import io.github.sashirestela.openai.domain.assistant.ThreadMessageRole;
import io.github.sashirestela.openai.domain.assistant.ThreadRequest;
import io.github.sashirestela.openai.domain.chat.ChatMessage;
import io.github.sashirestela.openai.domain.chat.ChatRequest;
import org.springframework.stereotype.Service;

@Service
public class OpenAiChatServiceImpl implements OpenAiChatService {

    private SimpleOpenAI openAI;

    OpenAiChatServiceImpl() {
        openAI = SimpleOpenAI.builder().apiKey(System.getenv("OPENAI_API_KEY")).build();
    }

    @Override
    public ThreadDto createThread(ThreadMessageDto messageDto) {
        return ThreadDto.builder()
                .threadId(requestNewThread().getId())
                .threadName(requestThreadName(messageDto.getContent()))
                .build();
    }

    private Thread requestNewThread() {
        return openAI.threads().create(ThreadRequest.builder().build()).join();
    }


    private String requestThreadName(String text) {
        return openAI.chatCompletions().create(createThreadNameRequest(text)).join().firstContent();
    }

    private static ChatRequest createThreadNameRequest(String text) {
        return ChatRequest.builder()
                .model(System.getenv("GPT_MODEL"))
                .message(ChatMessage.SystemMessage.of(System.getenv("GENERATE_CHATNAME")))
                .message(ChatMessage.UserMessage.of(text))
                .build();
    }

    @Override
    public String sendMessage(ThreadMessageDto messageDto) {
        return openAI.threadMessages()
                .create(messageDto.getThreadId(), ThreadMessageRequest.builder()
                        .role(ThreadMessageRole.USER)
                        .content(messageDto.getContent())
                        .build()).join().getContent().toString();
    }

}
