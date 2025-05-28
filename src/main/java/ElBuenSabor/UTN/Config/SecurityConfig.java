package ElBuenSabor.UTN.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer.FrameOptionsConfig;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity   // si luego querés usar @PreAuthorize, etc.
public class SecurityConfig {

    // 1) Defino el PasswordEncoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 2) Creo un usuario en memoria (puedes cambiar nombre/clave)
    @Bean
    public UserDetailsService users(PasswordEncoder encoder) {
        var user = User.builder()
                .username("admin")
                .password(encoder.encode("admin123"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    // 3) Configuro las reglas de seguridad
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // deshabilita CSRF para no necesitar token en cada petición
                .csrf(csrf -> csrf.disable())

                // habilita HTTP Basic
                .httpBasic(Customizer.withDefaults())

                // reglas de acceso
                .authorizeHttpRequests(auth -> auth
                        // deja libres consola H2 y swagger
                        .requestMatchers(
                                "/h2-console/**",
                                "/swagger-ui.html",
                                "/swagger-ui/**",
                                "/v3/api-docs/**"
                        ).permitAll()
                        // el resto requiere autenticación
                        .anyRequest().authenticated()
                )

                // opcional: si quieres, mantén formLogin también
                .formLogin(Customizer.withDefaults())

                // frameOptions para H2
                .headers(headers -> headers.frameOptions(FrameOptionsConfig::disable));

        return http.build();
    }

}

