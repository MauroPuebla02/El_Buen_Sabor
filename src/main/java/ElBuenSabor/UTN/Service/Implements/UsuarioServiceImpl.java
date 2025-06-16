package ElBuenSabor.UTN.Service.Implements;

import ElBuenSabor.UTN.Models.Model.Rol;
import ElBuenSabor.UTN.Models.Model.Usuario;
import ElBuenSabor.UTN.Repository.BaseRepository;
import ElBuenSabor.UTN.Repository.UsuarioRepository;
import ElBuenSabor.UTN.Service.BaseServiceImpl;
import ElBuenSabor.UTN.Service.Interface.iUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Long> implements iUsuarioService {

    @Autowired
    private UsuarioRepository repository;
    public UsuarioServiceImpl(BaseRepository<Usuario, Long> baseRepository) {
        super(baseRepository);
    }

    public List<Usuario> obtenerClientes() {
        return repository.findByRol(Rol.CLIENTE);
    }

    public List<Usuario> obtenerEmpleados() {
        List<Rol> rolesEmpleados = List.of(Rol.ADMIN, Rol.COCINERO, Rol.CAJERO, Rol.DELIVERY);
        return repository.findByRolIn(rolesEmpleados);
    }

    public static List<Rol> obtenerRolesEmpleados() {
        return List.of(Rol.ADMIN, Rol.COCINERO, Rol.CAJERO, Rol.DELIVERY);
    }

}
