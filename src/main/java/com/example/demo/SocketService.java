package com.example.demo;

import com.corundumstudio.socketio.SocketIOClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class SocketService {

    OpenAiChatService openAiChatService;

    public void sendMessage(ThreadMessageDto message, SocketIOClient senderClient) {

        ThreadDto thread;
        if(message.getThreadId()==null) {
            thread = openAiChatService.createThread(message);
            message.setThreadId(thread.getThreadId());
            senderClient.sendEvent(ServerEvents.THREAD_CREATED, thread);
            //TODO save thread
        }

        senderClient.sendEvent(ServerEvents.MESSAGE_CREATED, openAiChatService.sendMessage(message));
    }
}
