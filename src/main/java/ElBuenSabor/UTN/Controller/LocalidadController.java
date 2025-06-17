package ElBuenSabor.UTN.Controller;

import ElBuenSabor.UTN.Models.Model.Domicilio;
import ElBuenSabor.UTN.Models.Model.Localidad;
import ElBuenSabor.UTN.Service.Implements.DomicilioServiceImpl;
import ElBuenSabor.UTN.Service.Implements.LocalidadServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/localidades")
public class LocalidadController extends BaseControllerImpl<Localidad, LocalidadServiceImpl>{
    public LocalidadController(LocalidadServiceImpl service) {super(service); }
}
