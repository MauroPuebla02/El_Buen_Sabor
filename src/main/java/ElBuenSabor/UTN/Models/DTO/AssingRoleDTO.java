package ElBuenSabor.UTN.Models.DTO;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder


@Data
public class AssingRoleDTO {
    private String id;
    private List<String> roles;
}
