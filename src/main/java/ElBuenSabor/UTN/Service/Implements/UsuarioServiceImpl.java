package ElBuenSabor.UTN.Service.Implements;

import ElBuenSabor.UTN.Models.DTO.LoginDTO;
import ElBuenSabor.UTN.Models.DTO.RegistroDTO;
import ElBuenSabor.UTN.Models.Model.Rol;
import ElBuenSabor.UTN.Models.Model.Usuario;
import ElBuenSabor.UTN.Repository.BaseRepository;
import ElBuenSabor.UTN.Repository.UsuarioRepository;
import ElBuenSabor.UTN.Service.BaseServiceImpl;
import ElBuenSabor.UTN.Service.Interface.iUsuarioService;
import ElBuenSabor.UTN.Models.Mappers.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Long> implements iUsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioServiceImpl(BaseRepository<Usuario, Long> baseRepository,
                              UsuarioRepository repository,
                              UsuarioMapper usuarioMapper,
                              PasswordEncoder passwordEncoder) {
        super(baseRepository);
        this.repository = repository;
        this.usuarioMapper = usuarioMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registrar(RegistroDTO dto) {
        if (repository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Ya existe un usuario con ese correo electrónico.");
        }

        Usuario usuario = usuarioMapper.toUsuario(dto);
        usuario.setPassword(passwordEncoder.encode(dto.getPassword()));
        usuario.setRol(Rol.CLIENTE); // o Rol.USUARIO si cambiaste el enum
        repository.save(usuario);
    }

    @Override
    public List<Usuario> obtenerClientes() {
        return repository.findByRol(Rol.CLIENTE);
    }

    @Override
    public List<Usuario> obtenerEmpleados() {
        return repository.findByRolIn(List.of(Rol.ADMIN, Rol.COCINERO, Rol.CAJERO, Rol.DELIVERY));
    }

    @Override
    public Usuario login(LoginDTO dto) {
        Usuario usuario = repository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!passwordEncoder.matches(dto.getPassword(), usuario.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        return usuario;
    }

    @Override
    public Usuario registrarDesdeEntidad(Usuario usuario) {
        if (usuario.getPassword() != null && !usuario.getPassword().isEmpty()) {
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        }

        // Verificación opcional si ya existe el email
        if (repository.existsByEmail(usuario.getEmail())) {
            throw new RuntimeException("Ya existe un usuario con ese email.");
        }

        return repository.save(usuario);
    }
}
