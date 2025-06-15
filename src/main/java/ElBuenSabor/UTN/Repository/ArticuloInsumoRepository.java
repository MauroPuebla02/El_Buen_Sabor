package ElBuenSabor.UTN.Repository;

import ElBuenSabor.UTN.Models.Model.ArticuloInsumo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloInsumoRepository extends BaseRepository<ArticuloInsumo, Long> {

    @Query("""
        SELECT DISTINCT ai
          FROM ArticuloInsumo ai
          LEFT JOIN FETCH ai.unidad_de_medida udm
          LEFT JOIN FETCH ai.imagen img
          WHERE ai.categoria.id = :idCategoria
           AND ai.eliminado = false
        """)
    List<ArticuloInsumo> findArticulosInsumosByCategoria(@Param("idCategoria") Long idCategoria);

    @Modifying
    @Transactional
    @Query("UPDATE StockInsumoSucursal s SET s.stock_actual = :nuevoStock " +
            "WHERE s.articulo_insumo.id = :insumoId AND s.sucursal.id = :sucursalId AND s.eliminado = false")
    void actualizarStock(Long insumoId, Long sucursalId, int nuevoStock);


}
