package ElBuenSabor.UTN.Controller;

import ElBuenSabor.UTN.Models.Model.Promocion;
import ElBuenSabor.UTN.Service.Implements.PromocionServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/promociones")
public class PromocionController extends BaseControllerImpl<Promocion, PromocionServiceImpl>{
    public PromocionController(PromocionServiceImpl service) {super(service);}

    @GetMapping(value="/byTipoPromocion/{idTipoPromocion}")
    public List<Promocion> getPromocionesPorTipoPromocion (@PathVariable Long idTipoPromocion){
        return service.getPromocionesPorTipoPromocion(idTipoPromocion);
    }
}
