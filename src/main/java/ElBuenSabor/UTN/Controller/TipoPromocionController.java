package ElBuenSabor.UTN.Controller;

import ElBuenSabor.UTN.Models.Model.TipoPromocion;
import ElBuenSabor.UTN.Service.Implements.TipoPromocionServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tipo-promociones")
public class TipoPromocionController extends BaseControllerImpl<TipoPromocion, TipoPromocionServiceImpl>{
    public TipoPromocionController(TipoPromocionServiceImpl service) {super(service);}
}
