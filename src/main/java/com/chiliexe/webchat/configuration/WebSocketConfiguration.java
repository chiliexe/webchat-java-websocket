package com.chiliexe.webchat.configuration;

import com.chiliexe.webchat.service.WebSocketHandlerService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfiguration implements WebSocketConfigurer {

    public static final String SOCKET_ENDPOINT = "/chat";

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry ws) {
        
        ws.addHandler(getSocketHandler(), SOCKET_ENDPOINT)
            .setAllowedOrigins("*");
        
    }

    @Bean
    public WebSocketHandler getSocketHandler()
    {
        return new WebSocketHandlerService();
    }
    
}
