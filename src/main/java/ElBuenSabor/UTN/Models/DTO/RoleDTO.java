package ElBuenSabor.UTN.Models.DTO;

import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder

@Data
public class RoleDTO {
    private String name;
    private String description;
    private String Auth0RoleId;
    private Long id;
}

