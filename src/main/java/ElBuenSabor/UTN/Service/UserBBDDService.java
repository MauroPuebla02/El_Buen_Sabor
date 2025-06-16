package ElBuenSabor.UTN.Service;

import ElBuenSabor.UTN.Models.Model.Usuario;
import ElBuenSabor.UTN.Repository.UsuarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserBBDDService {

    protected final UsuarioRepository usuarioRepository;

    public UserBBDDService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public List<Usuario> findAll() throws Exception {
        try {
            return usuarioRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<Usuario> findAllActive() throws Exception {
        try {
            return usuarioRepository.findAll()
                    .stream()
                    .filter(u -> !u.isEliminado())
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Usuario findById(String id) throws Exception {
        try {
            Usuario usuario = usuarioRepository.getUserByAuth0Id(id);
            if (usuario == null) {
                throw new Exception("Usuario no encontrado");
            }
            return usuario;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Usuario save(Usuario entity) throws Exception {
        try {
            return usuarioRepository.save(entity);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Usuario update(Usuario entity) throws Exception {
        try {
            if (entity.getId() == null) {
                throw new Exception("La entidad a modificar debe contener un Id.");
            }
            return usuarioRepository.save(entity);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public boolean delete(String id) throws Exception {
        try {
            Usuario usuario = usuarioRepository.getUserByAuth0Id(id);
            if (usuario == null) {
                throw new Exception("Usuario no encontrado");
            }
            usuario.setEliminado(true);
            usuarioRepository.save(usuario);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public boolean deleteFisic(String id) throws Exception {
        try {
            Usuario usuario = usuarioRepository.getUserByAuth0Id(id);
            if (usuario == null) {
                throw new Exception("Usuario no encontrado");
            }
            usuarioRepository.delete(usuario);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Page<Usuario> findAll(Pageable pageable) throws Exception {
        try {
            return usuarioRepository.findAll(pageable);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
