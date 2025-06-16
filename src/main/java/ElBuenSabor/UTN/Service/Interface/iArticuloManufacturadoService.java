package ElBuenSabor.UTN.Service.Interface;

import ElBuenSabor.UTN.Models.Model.ArticuloManufacturado;
import ElBuenSabor.UTN.Service.iBaseService;

import java.util.List;

public interface iArticuloManufacturadoService extends iBaseService<ArticuloManufacturado, Long> {

    List<ArticuloManufacturado> findArticulosManufacturadosByCategoria(Long idCategoria);

    ArticuloManufacturado getArticuloManufacturadoPorId(Long id);
}
