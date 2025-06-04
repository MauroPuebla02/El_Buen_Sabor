package ElBuenSabor.UTN.Service.Interface;

import ElBuenSabor.UTN.Models.DTO.CategoriaByManufactoradoDTO;
import ElBuenSabor.UTN.Models.Model.Categoria;
import ElBuenSabor.UTN.Service.BaseService;

import java.util.List;

public interface iCategoriaService extends BaseService<Categoria, Long> {



    List<Categoria> findByCategoriaPadreIsNull();

    List<Categoria> findByTipoCategoria(Long idTipoCategoria);
}
