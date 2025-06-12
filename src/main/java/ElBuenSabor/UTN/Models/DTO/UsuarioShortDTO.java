package ElBuenSabor.UTN.Models.DTO;

import ElBuenSabor.UTN.Models.Model.Rol;

import java.time.LocalDate;

public class UsuarioShortDTO {
    private int id;
    private String nombre,apellido;
    private LocalDate fecha_nacimiento;
    private String rol, calle, provincia;

}
