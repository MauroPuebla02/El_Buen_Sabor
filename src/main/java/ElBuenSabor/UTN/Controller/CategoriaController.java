package ElBuenSabor.UTN.Controller;

import ElBuenSabor.UTN.Models.Model.Categoria;
import ElBuenSabor.UTN.Service.Implements.CategoriaServiceImpl;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController extends BaseControllerImpl<Categoria, CategoriaServiceImpl>{
    public CategoriaController(CategoriaServiceImpl service) {
        super(service);
    }


    @GetMapping(value="/ventas")
    public List<Categoria> findCategoriaParaVentas(){
        return service.findCategoriaParaVentas();
    }

    @GetMapping(value="/manufacturadosPadre")
    public List<Categoria> findByCategoriaPadreIsNull(){
        return service.findByCategoriaPadreIsNull();
    }

    @GetMapping(value="/manufacturados/{idTipoCategoria}")
    public List<Categoria> findByTipoCategoria(@PathVariable Long idTipoCategoria){
        return service.findByTipoCategoria(idTipoCategoria);
    }

}
