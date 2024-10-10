package com.example.demo;

import com.corundumstudio.socketio.SocketIONamespace;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SocketModule {

    private final SocketIOServer server;
    private final SocketService socketService;

    public SocketModule(SocketIOServer server, SocketService socketService) {
        this.server = server;
        this.socketService = socketService;

        SocketIONamespace chatNamespace = server.addNamespace("/chat");
        chatNamespace.addConnectListener(onConnected());
        chatNamespace.addDisconnectListener(onDisconnected());
        chatNamespace.addEventListener(ClientEvents.MESSAGE_GPT_SEND, ThreadMessageDto.class, onChatReceived());
    }

    private DataListener<ThreadMessageDto> onChatReceived() {
        return (senderClient, data, ackSender) -> {
            log.info(data.toString());
            socketService.sendMessage(data, senderClient);
        };
    }

    private ConnectListener onConnected() {
        return (client) -> {
            String room = client.getHandshakeData().getHttpHeaders().get("username");
            client.joinRoom(room);
            log.info("Socket ID[{}]  Connected to socket", client.getSessionId().toString());
        };

    }

    private DisconnectListener onDisconnected() {
        return client -> {
            String room = client.getHandshakeData().getHttpHeaders().get("username");
            client.leaveRoom(room);
            log.info("Client[{}] - Disconnected from socket", client.getSessionId().toString());
        };
    }
}