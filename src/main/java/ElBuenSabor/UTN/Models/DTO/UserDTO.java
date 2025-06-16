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
public class UserDTO {
    private String email;
    private String lastName;
    private String password;
    private String connection;
    private String name;
    private String nickName;
    private List<String> roles;
    private String auth0Id;
    private Long id;
}
