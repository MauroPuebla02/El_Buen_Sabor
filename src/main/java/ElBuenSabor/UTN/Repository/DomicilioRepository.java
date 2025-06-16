package ElBuenSabor.UTN.Repository;

import ElBuenSabor.UTN.Models.Model.Domicilio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DomicilioRepository extends BaseRepository<Domicilio,Long> {
    @Query(value= """
        SELECT D.ID, D.ELIMINADO, D.CALLE , D.CP , D.NUMERO , D.LOCALIDAD_ID , D.TIPO  FROM DOMICILIO AS D
        JOIN USUARIO_DOMICILIO AS UD
        ON D.id = UD.DOMICILIO_ID
        JOIN USUARIO AS U
        ON UD.USUARIO_ID = U.ID
        WHERE U.ID = ?1 AND D.ELIMINADO = FALSE
    """,nativeQuery = true)
    List<Domicilio> getDomiciliosPorUsuario(@Param("idUsuario") Long idUsuario);
}
