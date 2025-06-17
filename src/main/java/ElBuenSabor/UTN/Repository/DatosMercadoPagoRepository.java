package ElBuenSabor.UTN.Repository;

import ElBuenSabor.UTN.Models.Model.DatosMercadoPago;
import org.springframework.stereotype.Repository;

@Repository
public interface DatosMercadoPagoRepository extends BaseRepository<DatosMercadoPago, Long>{
    DatosMercadoPago findByPreferenceId(String preferenceId);
}
