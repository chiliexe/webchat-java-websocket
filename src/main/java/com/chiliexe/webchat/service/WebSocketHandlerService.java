package com.chiliexe.webchat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebSocketHandlerService extends TextWebSocketHandler {

    private final List<WebSocketSession> webSocketSessions = new ArrayList<>();
    
    @Override
    public void afterConnectionEstablished(WebSocketSession ws) throws Exception {
        webSocketSessions.add(ws);
    }
    
    
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        for (WebSocketSession webSocketSession : webSocketSessions) {
            webSocketSession.sendMessage(message);
        }
    }



    @Override
    public void afterConnectionClosed(WebSocketSession ws, CloseStatus arg1) throws Exception {
        webSocketSessions.remove(ws);        
    }
}
