package ElBuenSabor.UTN.Controller;

import ElBuenSabor.UTN.Models.Model.ArticuloManufacturado;
import ElBuenSabor.UTN.Service.Implements.ArticuloManufacturadoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/articulos-manufacturados")
public class ArticuloManufacturadoController extends BaseControllerImpl<ArticuloManufacturado, ArticuloManufacturadoServiceImpl> {


    public ArticuloManufacturadoController(ArticuloManufacturadoServiceImpl service) {
        super(service);
    }
}
