package ElBuenSabor.UTN.Repository;

import ElBuenSabor.UTN.Models.Model.DatosMercadoPago;

public interface DatosMercadoPagoRepository extends BaseRepository<DatosMercadoPago, Long>{
    DatosMercadoPago findByPreferenceId(String preferenceId);
}
