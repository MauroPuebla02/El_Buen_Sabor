package ElBuenSabor.UTN.Controller;

import ElBuenSabor.UTN.Models.Model.ArticuloInsumo;
import ElBuenSabor.UTN.Service.Implements.ArticuloInsumoServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/articulos_insumos")
public class ArticuloInsumoController extends BaseControllerImpl<ArticuloInsumo, ArticuloInsumoServiceImpl>{
    public ArticuloInsumoController(ArticuloInsumoServiceImpl service) {super(service);}
/*
    @GetMapping(value="/byCategoria/{idCategoria}")
    public void getArticulosInsumosByCategoria(@PathVariable("idCategoria") Long idCategoria){
        service.findArticulosInsumosByCategoria(idCategoria);
    }


 */
}
