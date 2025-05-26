package ElBuenSabor.UTN.Controller;

import ElBuenSabor.UTN.Models.Model.Usuario;
import ElBuenSabor.UTN.Service.Implements.UsuarioServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController extends BaseControllerImpl<Usuario, UsuarioServiceImpl>{
    public UsuarioController(UsuarioServiceImpl service) {
        this.service = service;
    }
}
