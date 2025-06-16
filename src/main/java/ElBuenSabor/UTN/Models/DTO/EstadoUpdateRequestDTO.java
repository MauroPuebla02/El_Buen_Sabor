package ElBuenSabor.UTN.Models.DTO;

import ElBuenSabor.UTN.Models.Model.Estado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstadoUpdateRequestDTO {
    private Long id;
    private Estado estadoPedido;


}
