package ElBuenSabor.UTN.Repository;

//import com.example.auth0UsersAndRoles.entities.Roles;
import ElBuenSabor.UTN.Models.Model.Roles;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends BaseRepository<Roles,Long> {
    Optional<Roles> findByAuth0RoleId(String name);
    Roles getRolesByAuth0RoleId (String id);
    Roles getRolesByName(String name);

}
