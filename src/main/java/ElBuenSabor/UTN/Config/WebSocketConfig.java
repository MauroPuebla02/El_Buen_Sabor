package ElBuenSabor.UTN.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    // 1) Definimos el endpoint al que se conectarán los clientes
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry
                .addEndpoint("/ws")                  // URL: ws://host:puerto/ws
                .setAllowedOriginPatterns("*")      // permite CORS
                .withSockJS();                      // fallback a SockJS
    }

    // 2) Configuramos prefijos de cola y broker simple en memoria
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic", "/queue");  // topics públicos y colas privadas
        registry.setApplicationDestinationPrefixes("/app");
        registry.setUserDestinationPrefix("/user");       // para convertAndSendToUser()
    }
}