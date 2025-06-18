package ElBuenSabor.UTN.Controller;

import ElBuenSabor.UTN.Models.DTO.LoginDTO;
import ElBuenSabor.UTN.Models.DTO.RegistroDTO;
import ElBuenSabor.UTN.Models.Model.Rol;
import ElBuenSabor.UTN.Models.Model.Usuario;
import ElBuenSabor.UTN.Service.Implements.UsuarioServiceImpl;
import ElBuenSabor.UTN.Service.Interface.iUsuarioService;
import jakarta.persistence.ManyToOne;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.ok(iUsuarioService.obtenerRolesEmpleados());
    }

    @PostMapping("/registro")
    public ResponseEntity<?> registrar(@RequestBody RegistroDTO dto) {
        service.registrar(dto); // accedés a la instancia inyectada por el padre
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO dto) {
        Usuario usuario = service.login(dto); // 'service' ya está inyectado por herencia
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/registrarEncriptado")
    public ResponseEntity<?> registrarUsuarioDirecto(@RequestBody Usuario usuario) {
        Usuario u = service.registrarDesdeEntidad(usuario);
        return ResponseEntity.ok(u);
    }

}
