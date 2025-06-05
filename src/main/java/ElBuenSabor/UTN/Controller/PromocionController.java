package ElBuenSabor.UTN.Controller;

import ElBuenSabor.UTN.Models.Model.Promocion;
import ElBuenSabor.UTN.Service.Implements.PromocionServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("promociones")
public class PromocionController extends BaseControllerImpl<Promocion, PromocionServiceImpl>{
    public PromocionController(PromocionServiceImpl service) {super(service);}
}
