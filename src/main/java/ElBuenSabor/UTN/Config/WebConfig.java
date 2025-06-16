package ElBuenSabor.UTN.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")                            // o solo "/categorias/**"
                .allowedOrigins("http://localhost:5173")      // tu front
                .allowedMethods("GET","POST","PUT","PATCH","DELETE") // los que necesites
                .allowCredentials(true);
    }
}
