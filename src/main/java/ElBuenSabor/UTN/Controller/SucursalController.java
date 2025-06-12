package ElBuenSabor.UTN.Controller;

import ElBuenSabor.UTN.Models.Model.Sucursal;
import ElBuenSabor.UTN.Service.Implements.SucursalServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sucursales")
public class SucursalController extends BaseControllerImpl<Sucursal, SucursalServiceImpl>{
    public SucursalController(SucursalServiceImpl service) {super(service);}
}
