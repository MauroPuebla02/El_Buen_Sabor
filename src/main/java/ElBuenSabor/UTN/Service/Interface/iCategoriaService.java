package ElBuenSabor.UTN.Service.Interface;

import ElBuenSabor.UTN.Models.Model.Categoria;
import ElBuenSabor.UTN.Service.iBaseService;

import java.util.List;

public interface iCategoriaService extends iBaseService<Categoria, Long> {

    List<Categoria> findByCategoriaPadreIsNull();

    List<Categoria> findByTipoCategoria(Long idTipoCategoria);
}
