package ElBuenSabor.UTN.Repository;

import ElBuenSabor.UTN.Models.DTO.ArticuloManufacturadoByCategoriaDTO;
import ElBuenSabor.UTN.Models.Model.ArticuloManufacturado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloManufacturadoRepository extends BaseRepository<ArticuloManufacturado, Long> {

    @Query(value = """

            SELECT A.ID,
                       A.DENOMINACION,
                       AM.DESCRIPCION,
                       A.PRECIO_VENTA,
                       AM.TIEMPO_ESTIMADO_EN_MINUTOS
                  FROM CATEGORIA C
                  JOIN CATEGORIA_ARTICULO CA
                    ON C.ID = CA.CATEGORIA_ID
                  JOIN ARTICULO A
                    ON CA.ARTICULO_ID = A.ID
                  JOIN ARTICULO_MANUFACTURADO AM
                    ON A.ID = AM.ID
                 WHERE C.ID = ?1 AND A.ELIMINADO !=TRUE AND C.ELIMINADO != TRUE
        """,
            nativeQuery = true)
    List<ArticuloManufacturadoByCategoriaDTO> findArticulosManufacturadosByCategoria(
            @Param("idCategoria") Long idCategoria);
}
