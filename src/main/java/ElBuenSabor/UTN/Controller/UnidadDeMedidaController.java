package ElBuenSabor.UTN.Controller;

import ElBuenSabor.UTN.Models.Model.UnidadDeMedida;
import ElBuenSabor.UTN.Service.Implements.UnidadDeMedidaServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/unidades_de_medidas")
public class UnidadDeMedidaController extends BaseControllerImpl<UnidadDeMedida, UnidadDeMedidaServiceImpl>{
    public UnidadDeMedidaController(UnidadDeMedidaServiceImpl service) {
        super(service);
    }
}
