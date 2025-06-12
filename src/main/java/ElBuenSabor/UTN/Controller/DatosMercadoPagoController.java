package ElBuenSabor.UTN.Controller;

import ElBuenSabor.UTN.Models.Model.DatosMercadoPago;
import ElBuenSabor.UTN.Service.Implements.DatosMercadoPagoServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/pagos")
public class DatosMercadoPagoController extends BaseControllerImpl<DatosMercadoPago, DatosMercadoPagoServiceImpl>{
    public DatosMercadoPagoController(DatosMercadoPagoServiceImpl service) {super(service);}

    @PostMapping("/preference")
    public ResponseEntity<Map<String, String>> crearPreference(@RequestBody Map<String, Object> body)  {
        BigDecimal monto = new BigDecimal(body.get("monto").toString());
        String descripcion = body.get("descripcion").toString();
        String checkoutUrl = service.crearPreferencia(monto, descripcion);
        return ResponseEntity.ok(Map.of("url", checkoutUrl));
    }

    // Endpoint para webhook de notificaciones
    @PostMapping("/notifications")
    public ResponseEntity<Void> recibirNotificacion(@RequestParam Map<String,String> params) {
        String topic = params.get("topic");
        String id = params.get("id");
        // Lógica: si topic="payment", consulta a Mercado Pago y actualiza
        // ...
        return ResponseEntity.ok().build();
    }
}
