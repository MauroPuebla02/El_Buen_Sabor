package ElBuenSabor.UTN;

//import ElBuenSabor.UTN.Models.Model.Categoria;
import ElBuenSabor.UTN.Service.RoleBBDDService;
import ElBuenSabor.UTN.Service.UserAuth0Service;
import com.auth0.json.mgmt.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;
import java.util.Set;
import ElBuenSabor.UTN.Models.Model.Roles;
import ElBuenSabor.UTN.Models.Model.Usuario;
import ElBuenSabor.UTN.Models.DTO.RoleDTO;
import ElBuenSabor.UTN.Models.DTO.UserDTO;
import ElBuenSabor.UTN.Repository.RoleRepository;
import ElBuenSabor.UTN.Service.RoleAuth0Service;
import ElBuenSabor.UTN.Service.UserBBDDService;


@SpringBootApplication
public class ElBuenSaborApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElBuenSaborApplication.class, args);
		System.out.println("HOLA MUNDO !!!! :D XD");
	}
/*
	@Bean
	public CommandLineRunner cargarCategorias(CategoriaRepository repo) {
		return args -> {
			Categoria hijo1 = Categoria.builder().denominacion("Hijo 1").build();
			Categoria hijo2 = Categoria.builder().denominacion("Hijo 2").build();
			Categoria padre = Categoria.builder()
					.denominacion("Padre")
					.categorias_hijas(List.of(hijo1, hijo2))
					.build();
			repo.save(padre);
			System.out.println("Categoría guardada: " + padre);
		};
	}
*/

/*
	@Bean
	public CommandLineRunner run(RoleAuth0Service roleService,
								 RoleBBDDService roleServicebbdd,
								 RoleRepository roleRepository,
								 UserAuth0Service userService,
								 UserBBDDService userBBDDService) {
		return args -> {

			RoleDTO rolAdminDTO = new RoleDTO();
			rolAdminDTO.setName("Administrador");
			rolAdminDTO.setDescription("Admin del local");

			RoleDTO rolClienteDTO = new RoleDTO();
			rolClienteDTO.setName("Cliente");
			rolClienteDTO.setDescription("Cliente del local");

			// ==== 1. Crear Roles ====
			crearRolInicial(rolAdminDTO, roleService, roleServicebbdd );
			crearRolInicial(rolClienteDTO, roleService, roleServicebbdd);


			// ==== 2. Crear Usuario Administrador ====
			Roles rolAdmin = roleServicebbdd.findByName("Administrador");

			UserDTO adminDTO = new UserDTO();
					adminDTO.setEmail("admin@buensabor.com");
					adminDTO.setName("Administrador");
					adminDTO.setNickName("admin total");
					adminDTO.setPassword("Admin@admin");
			adminDTO.setConnection("Username-Password-Authentication");
					adminDTO.setRoles(List.of(rolAdmin.getAuth0RoleId()));


			com.auth0.json.mgmt.users.User newUser = userService.createUser(adminDTO);
			userService.assignRoles(newUser.getId(), adminDTO.getRoles());

			Usuario adminBBDD = Usuario.builder()
					.auth0Id(newUser.getId())
					.nombre("Administrador")                   // o adminDTO.getName()
					.apellido("del sistema")                   // valor por defecto
					.telefono("123456789")                     // opcional
					.email(newUser.getEmail())
					.roles(Set.of(rolAdmin))
					.build();


			userBBDDService.save(adminBBDD);

			System.out.println("Roles y usuario administrador creados correctamente.");

		};


	}

	private void crearRolInicial(RoleDTO roleDTO,
								 RoleAuth0Service roleService,
								 RoleBBDDService roleServicebbdd) throws Exception {

		Role rolAuth = null;
		try {
			// Crear en Auth0
			rolAuth = roleService.createRole(roleDTO);

			// Guardar en BBDD
			Roles roles = Roles.builder()
					.auth0RoleId(rolAuth.getId())
					.description(roleDTO.getDescription())
					.name(roleDTO.getName())
					.build();

			 roleServicebbdd.save(roles);

		} catch (Exception e) {
			// Revertir Auth0 si falla BBDD
			if (rolAuth != null && rolAuth.getId() != null) {
				try {
					roleService.deleteRole(rolAuth.getId());
				} catch (Exception ex) {
					System.err.println("Error al eliminar rol en Auth0: " + ex.getMessage());
				}
			}
			throw e;
		}
	}
*/
}
