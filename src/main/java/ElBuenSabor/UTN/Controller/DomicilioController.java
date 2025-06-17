package ElBuenSabor.UTN.Controller;

import ElBuenSabor.UTN.Models.Model.Domicilio;
import ElBuenSabor.UTN.Service.Implements.DomicilioServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/domicilios")
public class DomicilioController extends BaseControllerImpl<Domicilio, DomicilioServiceImpl>{
    public DomicilioController(DomicilioServiceImpl service) {super(service);}
    @GetMapping(value="/ByUsuario/{idUsuario}")
    public List<Domicilio> getDomiciliosPorUsuario(@PathVariable("idUsuario") Long idUsuario){
        return service.getDomiciliosPorUsuario(idUsuario);
    }
}
