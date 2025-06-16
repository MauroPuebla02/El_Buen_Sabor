package ElBuenSabor.UTN.Models.DTO;

import ElBuenSabor.UTN.Models.Model.Estado;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter@Setter
public class PedidoHistorialClienteDTO {
    private Long id;
    private String hora;
    private String fecha;
    private Estado estado;
    private List<String> productos;
}
