package ElBuenSabor.UTN.Service.Interface;


import ElBuenSabor.UTN.Models.Model.DatosMercadoPago;
import ElBuenSabor.UTN.Service.iBaseService;

import java.math.BigDecimal;

public interface iDatosMercadoPagoService extends iBaseService<DatosMercadoPago,Long> {
    String crearPreferencia(BigDecimal monto, String descripcion);

    void actualizarPago(String paymentId, String status, String preferenceId, BigDecimal monto);
}
