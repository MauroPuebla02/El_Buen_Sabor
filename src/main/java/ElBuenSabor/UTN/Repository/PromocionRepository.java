package ElBuenSabor.UTN.Repository;

import ElBuenSabor.UTN.Models.Model.ArticuloManufacturado;
import ElBuenSabor.UTN.Models.Model.Promocion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PromocionRepository extends BaseRepository<Promocion,Long> {

    @Query(value="""
        SELECT * FROM PROMOCION AS P
        WHERE P.TIPO_PROMOCION_ID = ?1 AND ELIMINADO = FALSE
        """, nativeQuery=true)
    List<Promocion> getPromocionesPorTipoPromocion(@Param("idTipoPromocion") Long idTipoPromocion);

}
