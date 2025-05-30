package ElBuenSabor.UTN.Controller;

import ElBuenSabor.UTN.Models.Model.TipoCategoria;
import ElBuenSabor.UTN.Service.Implements.TipoCategoriaServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tipo_categorias")
public class TipoCategoriaController extends BaseControllerImpl<TipoCategoria, TipoCategoriaServiceImpl>{
    public TipoCategoriaController(TipoCategoriaServiceImpl service) {
        super(service);
    }
}
