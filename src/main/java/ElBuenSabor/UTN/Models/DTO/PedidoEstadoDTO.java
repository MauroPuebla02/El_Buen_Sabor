package ElBuenSabor.UTN.Models.DTO;

import ElBuenSabor.UTN.Models.Model.Estado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoEstadoDTO {
    private Long idPedido;
    private Estado estadoPedido;
    private LocalDateTime fechaModificacion;
}