package ElBuenSabor.UTN.Controller;

import ElBuenSabor.UTN.Models.Model.Factura;
import ElBuenSabor.UTN.Service.Implements.FacturaServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("facturas")
public class FacturaController extends BaseControllerImpl<Factura, FacturaServiceImpl> {
    public FacturaController(FacturaServiceImpl service) {super(service);}
}
