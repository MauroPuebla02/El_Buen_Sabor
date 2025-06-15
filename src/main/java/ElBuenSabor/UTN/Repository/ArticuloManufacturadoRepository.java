package ElBuenSabor.UTN.Repository;

import ElBuenSabor.UTN.Models.ProjectionDTO.ArticuloManufacturadoByCategoriaDTO;
import ElBuenSabor.UTN.Models.Model.ArticuloManufacturado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloManufacturadoRepository extends BaseRepository<ArticuloManufacturado, Long> {
    @Query("""
        SELECT DISTINCT am
          FROM ArticuloManufacturado am
          LEFT JOIN FETCH am.unidad_de_medida udm
          LEFT JOIN FETCH am.imagen img
          LEFT JOIN FETCH am.detalles d
          LEFT JOIN FETCH d.articulo_insumo ai
         WHERE am.categoria.id = :idCategoria
           AND am.eliminado = false
        """)
    List<ArticuloManufacturado> findArticulosManufacturadosByCategoria(@Param("idCategoria") Long idCategoria);

    @Query("""
        SELECT DISTINCT am
        FROM ArticuloManufacturado am
        LEFT JOIN FETCH am.unidad_de_medida udm
        LEFT JOIN FETCH am.imagen img
        LEFT JOIN FETCH am.detalles d
        LEFT JOIN FETCH d.articulo_insumo ai
        WHERE am.id = :id
          AND am.eliminado = false
    """)
    ArticuloManufacturado getArticuloManufacturadoPorId(@Param("id") Long id);

    @Query(value = """

            SELECT A.ID,
                       A.DENOMINACION,
                       AM.DESCRIPCION,
                       A.PRECIO_VENTA,
                       AM.TIEMPO_ESTIMADO_EN_MINUTOS,
                FROM ARTICULO AS A
                JOIN ARTICULO_MANUFACTURADO AS AM ON AM.ID = A.ID
                WHERE A.CATEGORIA_ID = ?1
                  AND A.ELIMINADO = FALSE
        """,
            nativeQuery = true)
    List<ArticuloManufacturadoByCategoriaDTO> findArticulosManufacturadosByCategoria2(@Param("idCategoria") Long idCategoria);
}
