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

    public void sendMessage(ChatMessageDTO message, String eventName, SocketIOClient senderClient) {
//        for (SocketIOClient client : senderClient.getNamespace().getRoomOperations(message.getFrom()).getClients()) {
//            if (!client.getSessionId().equals(senderClient.getSessionId())) {
//                client.sendEvent(eventName, createMessage(message.getMessage()));
//            }
//        }
        ChatMessageDTO responce = openAiChatService.processRequest(message);
        senderClient.sendEvent(eventName, responce);
    }
}
