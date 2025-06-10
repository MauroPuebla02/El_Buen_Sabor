package ElBuenSabor.UTN.Service.Interface;

import ElBuenSabor.UTN.Models.Model.ArticuloInsumo;
import ElBuenSabor.UTN.Models.Model.ArticuloManufacturado;
import ElBuenSabor.UTN.Service.BaseService;

import java.util.List;

public interface iArticuloInsumoService extends BaseService<ArticuloInsumo, Long> {

    List<ArticuloInsumo> findArticulosInsumosByCategoria(Long idCategoria);

}
