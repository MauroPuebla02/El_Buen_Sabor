package ElBuenSabor.UTN.Controller;

import ElBuenSabor.UTN.Models.DTO.CategoriaByManufactoradoDTO;
import ElBuenSabor.UTN.Models.Model.Categoria;
import ElBuenSabor.UTN.Service.Implements.CategoriaServiceImpl;
import lombok.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController extends BaseControllerImpl<Categoria, CategoriaServiceImpl>{
    public CategoriaController(CategoriaServiceImpl service) {
        super(service);
    }

    @GetMapping(value="/manufacturados")
    public List<CategoriaByManufactoradoDTO> getcategoriasManufacturados(){
        return service.getCategoriasManufacturados();
    }

}
