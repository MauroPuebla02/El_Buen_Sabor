package ElBuenSabor.UTN.Service.Interface;

import ElBuenSabor.UTN.Models.DTO.ArticuloManufacturadoByCategoriaDTO;
import ElBuenSabor.UTN.Models.Model.ArticuloManufacturado;
import ElBuenSabor.UTN.Service.BaseService;

import java.util.List;

public interface iArticuloManufacturadoService extends BaseService<ArticuloManufacturado, Long> {

    List<ArticuloManufacturadoByCategoriaDTO> findArticulosManufacturadosByCategoria(Long idCategoria);
}
