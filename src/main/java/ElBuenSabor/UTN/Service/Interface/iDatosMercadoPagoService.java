package ElBuenSabor.UTN.Service.Interface;


import ElBuenSabor.UTN.Models.Model.DatosMercadoPago;
import ElBuenSabor.UTN.Models.Model.Pedido;
import ElBuenSabor.UTN.Service.iBaseService;

import java.math.BigDecimal;

public interface iDatosMercadoPagoService extends iBaseService<DatosMercadoPago,Long> {
    String crearPreferencia(Pedido pedido);

    void actualizarPago(String paymentId, String status, String preferenceId, BigDecimal monto);
}
