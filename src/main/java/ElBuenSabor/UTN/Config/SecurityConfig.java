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
                // -- permisos on paths --
                .authorizeHttpRequests(auth -> auth
                        // libero H2-console y swagger
                        .requestMatchers("/h2-console/**",
                                "/swagger-ui.html",
                                "/swagger-ui/**",
                                "/v3/api-docs/**"
                        ).permitAll()
                        // cualquier otra petición requiere autenticación
                        .anyRequest().authenticated()
                )

                // -- form-login por defecto --
                .formLogin(Customizer.withDefaults())
                .logout(Customizer.withDefaults())

                // -- H2 necesita desactivar CSRF en su endpoint y permisos de frame --
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/h2-console/**")
                )
                .headers(headers -> headers
                        .frameOptions(FrameOptionsConfig::disable)
                );

        return http.build();
    }
}

