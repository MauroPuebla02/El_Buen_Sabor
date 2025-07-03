package ElBuenSabor.UTN.Models.DTO;


import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter

public class RegistroDTO {

    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String password;
    private LocalDate fecha_nacimiento;
}
