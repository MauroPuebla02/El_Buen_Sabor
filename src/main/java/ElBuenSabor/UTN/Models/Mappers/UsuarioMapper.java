package ElBuenSabor.UTN.Models.Mappers;


import ElBuenSabor.UTN.Models.DTO.RegistroDTO;
import ElBuenSabor.UTN.Models.Model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mappings({

            @Mapping(target = "id", ignore = true),
            @Mapping(target = "rol", ignore = true),
            @Mapping(target = "pedidos", ignore = true),
            @Mapping(target = "domicilios", ignore = true),
            @Mapping(target = "sucursales", ignore = true),
            @Mapping(target = "usuario_A0", ignore = true),
            @Mapping(target = "imagen", ignore = true)
    })
    Usuario toUsuario(RegistroDTO dto);
}
