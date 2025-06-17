package ElBuenSabor.UTN.Controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioA0Controller {

    @GetMapping("/api/userinfo")
    public String getUserInfo(@AuthenticationPrincipal Jwt jwt) {
        String email = jwt.getClaimAsString("email");
        String sub = jwt.getSubject(); // el ID de Auth0
        return "Usuario logueado: " + email + " (sub: " + sub + ")";
    }
}