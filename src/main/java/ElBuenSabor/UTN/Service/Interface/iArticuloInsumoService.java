package ElBuenSabor.UTN.Service.Interface;

import ElBuenSabor.UTN.Models.Model.ArticuloInsumo;
import ElBuenSabor.UTN.Service.iBaseService;

import java.util.List;

public interface iArticuloInsumoService extends iBaseService<ArticuloInsumo, Long> {

    List<ArticuloInsumo> findArticulosInsumosByCategoria(Long idCategoria);
}
