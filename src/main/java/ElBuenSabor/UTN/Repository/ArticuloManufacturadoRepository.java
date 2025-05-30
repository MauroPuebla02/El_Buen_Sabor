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
           FROM CATEGORIA AS C
           JOIN ARTICULO AS A
           ON A.CATEGORIA_ID = C.ID
           JOIN ARTICULO_MANUFACTURADO AS AM
           ON AM.ID = A.ID
           WHERE C.ID=?1 AND C.ELIMINADO = FALSE AND A.ELIMINADO = FALSE
        """,
            nativeQuery = true)
    List<ArticuloManufacturadoByCategoriaDTO> findArticulosManufacturadosByCategoria(
            @Param("idCategoria") Long idCategoria);
}
