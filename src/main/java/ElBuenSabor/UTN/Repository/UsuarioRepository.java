package ElBuenSabor.UTN.Repository;

import ElBuenSabor.UTN.Models.Model.Rol;
import ElBuenSabor.UTN.Models.Model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario, Long> {
    // Clientes
    List<Usuario> findByRol(Rol rol);

    // Empleados
    List<Usuario> findByRolIn(List<Rol> roles);
}
