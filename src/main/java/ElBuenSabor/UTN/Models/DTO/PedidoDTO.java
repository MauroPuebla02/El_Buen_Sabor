package ElBuenSabor.UTN.Models.DTO;

import ElBuenSabor.UTN.Models.Model.Estado;
import ElBuenSabor.UTN.Models.Model.FormaPago;
import ElBuenSabor.UTN.Models.Model.TipoEnvio;

import java.time.LocalDate;
import java.time.LocalTime;

public class PedidoDTO {
    private LocalTime hora_estimada_finalizacion;
    private double total;
    private Estado estado_pedido;
    private FormaPago forma_pago;
    private LocalDate fecha_pedido;
    private String nombreUsuario;
}
