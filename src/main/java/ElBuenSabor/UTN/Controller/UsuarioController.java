package ElBuenSabor.UTN.Controller;

import ElBuenSabor.UTN.Models.Model.Usuario;
import ElBuenSabor.UTN.Service.Implements.UsuarioServiceImpl;
import jakarta.persistence.ManyToOne;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController extends BaseControllerImpl<Usuario, UsuarioServiceImpl>{
    public UsuarioController(UsuarioServiceImpl service) {
        super(service);
    }

}
