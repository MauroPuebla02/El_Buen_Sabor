package ElBuenSabor.UTN.Controller;

import ElBuenSabor.UTN.Models.Model.ArticuloInsumo;
import ElBuenSabor.UTN.Models.Model.ArticuloManufacturado;
import ElBuenSabor.UTN.Service.Implements.ArticuloInsumoServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/articulos_insumos")
public class ArticuloInsumoController extends BaseControllerImpl<ArticuloInsumo, ArticuloInsumoServiceImpl>{
    public ArticuloInsumoController(ArticuloInsumoServiceImpl service) {super(service);}

    @GetMapping(value="/byCategoria/{idCategoria}")
    public List<ArticuloInsumo> getArticulosInsumosPorCategoria(@PathVariable("idCategoria") Long idCategoria){
        return service.findArticulosInsumosByCategoria(idCategoria);
    }
}
