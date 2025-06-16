package ElBuenSabor.UTN.Repository;

import ElBuenSabor.UTN.Models.Model.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario, Long> {

    Usuario getUserByAuth0Id (String id);
}
