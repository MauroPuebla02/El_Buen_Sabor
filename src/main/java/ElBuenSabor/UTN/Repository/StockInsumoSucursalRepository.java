package ElBuenSabor.UTN.Repository;

import ElBuenSabor.UTN.Models.Model.StockInsumoSucursal;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StockInsumoSucursalRepository extends BaseRepository<StockInsumoSucursal, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE StockInsumoSucursal s SET s.stock_actual = :nuevoStock " +
            "WHERE s.articulo_insumo.id = :insumoId AND s.sucursal.id = :sucursalId AND s.eliminado = false")
    void actualizarStock2(Long insumoId, Long sucursalId, int nuevoStock);

}
