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
                FROM ARTICULO AS A
                JOIN ARTICULO_MANUFACTURADO AS AM ON AM.ID = A.ID
                WHERE A.CATEGORIA_ID = ?1
                  AND A.ELIMINADO = FALSE
        """,
            nativeQuery = true)
    List<ArticuloManufacturadoByCategoriaDTO> findArticulosManufacturadosByCategoria(
            @Param("idCategoria") Long idCategoria);


}
