package ElBuenSabor.UTN.Service.Interface;

import ElBuenSabor.UTN.Models.DTO.LoginDTO;
import ElBuenSabor.UTN.Models.DTO.RegistroDTO;
import ElBuenSabor.UTN.Models.Model.Rol;
import ElBuenSabor.UTN.Models.Model.Usuario;
import ElBuenSabor.UTN.Service.iBaseService;

import java.util.List;

public interface iUsuarioService extends iBaseService<Usuario, Long> {
    void registrar(RegistroDTO dto);

    List<Usuario> obtenerClientes();

    List<Usuario> obtenerEmpleados();

    static List<Rol> obtenerRolesEmpleados() {
        return List.of(Rol.ADMIN, Rol.COCINERO, Rol.CAJERO, Rol.DELIVERY);
    }

    Usuario login(LoginDTO dto);

}
