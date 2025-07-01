package ElBuenSabor.UTN.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;  // <— ¡importá esto!

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webClient() {          // <— método normal, sin genéricos
        return WebClient.builder()
                .baseUrl("https://www.reddit.com")
                .defaultHeader("User-Agent", "mi-app-java")
                .build();
    }

}