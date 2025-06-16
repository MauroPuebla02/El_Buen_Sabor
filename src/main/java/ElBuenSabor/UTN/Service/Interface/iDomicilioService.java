package ElBuenSabor.UTN.Service.Interface;

import ElBuenSabor.UTN.Models.Model.Domicilio;
import ElBuenSabor.UTN.Service.iBaseService;

import java.util.List;

public interface iDomicilioService extends iBaseService<Domicilio, Long> {
    List<Domicilio> getDomiciliosPorUsuario(Long idUsuario);
}
