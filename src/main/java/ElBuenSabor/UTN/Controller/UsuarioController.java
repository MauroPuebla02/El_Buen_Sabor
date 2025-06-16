package ElBuenSabor.UTN.Controller;

import ElBuenSabor.UTN.Models.Model.Rol;
import ElBuenSabor.UTN.Models.Model.Usuario;
import ElBuenSabor.UTN.Service.Implements.UsuarioServiceImpl;
import jakarta.persistence.ManyToOne;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController extends BaseControllerImpl<Usuario, UsuarioServiceImpl>{
    public UsuarioController(UsuarioServiceImpl service) {
        super(service);
    }
    @GetMapping("/clientes")
    public ResponseEntity<List<Usuario>> getClientes() {
        return ResponseEntity.ok(service.obtenerClientes());
    }

    @GetMapping("/empleados")
    public ResponseEntity<List<Usuario>> getEmpleados() {
        return ResponseEntity.ok(service.obtenerEmpleados());
    }

    @GetMapping("/roles")
    public ResponseEntity<List<Rol>> getRolesEmpleados() {
        return ResponseEntity.ok(UsuarioServiceImpl.obtenerRolesEmpleados());
    }

}
