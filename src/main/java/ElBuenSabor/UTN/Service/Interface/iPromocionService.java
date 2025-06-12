package ElBuenSabor.UTN.Service.Interface;

import ElBuenSabor.UTN.Models.Model.Promocion;
import ElBuenSabor.UTN.Service.iBaseService;

import java.util.List;

public interface iPromocionService extends iBaseService<Promocion, Long> {

    List<Promocion> getPromocionesPorTipoPromocion(Long idTipoPromocion);
}
