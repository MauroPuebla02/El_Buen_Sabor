package ElBuenSabor.UTN.Controller;

import ElBuenSabor.UTN.Models.Model.Articulo;
import ElBuenSabor.UTN.Models.Model.ArticuloManufacturado;
import ElBuenSabor.UTN.Service.Implements.ArticuloManufacturadoServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/articulos_manufacturados")
public class ArticuloManufacturadoController extends BaseControllerImpl<ArticuloManufacturado, ArticuloManufacturadoServiceImpl> {


    public ArticuloManufacturadoController(ArticuloManufacturadoServiceImpl service) {
        super(service);
    }

    @GetMapping(value="/byCategoria/{idCategoria}")
    public List<ArticuloManufacturado> getArticulosManufacturadoPorCategoria(@PathVariable("idCategoria") Long idCategoria){
        return service.findArticulosManufacturadosByCategoria(idCategoria);
    }

    @GetMapping(value="/byId/{id}")
    public ArticuloManufacturado getArticuloManufacturadoPorId(@PathVariable("id") Long id){
        return service.getArticuloManufacturadoPorId(id);
    }
    @GetMapping(value="/con_insumos")
    public List<Articulo> getArticulosManufacturadoConInsumos(){
        return service.findArticulosManufacturadoConInsumos();
    }
}
