package ElBuenSabor.UTN.Controller;

import ElBuenSabor.UTN.Models.Model.Domicilio;
import ElBuenSabor.UTN.Service.Implements.DomicilioServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("domicilios")
public class DomicilioController extends BaseControllerImpl<Domicilio, DomicilioServiceImpl>{
    public DomicilioController(DomicilioServiceImpl service) {super(service);}
}
