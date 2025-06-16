package ElBuenSabor.UTN.Repository;

import ElBuenSabor.UTN.Models.DTO.ArticuloManufacturadoPedidoDTO;
import ElBuenSabor.UTN.Models.Model.Estado;
import ElBuenSabor.UTN.Models.Model.Pedido;
import ElBuenSabor.UTN.Models.Model.TipoEnvio;
import ElBuenSabor.UTN.Models.Model.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PedidoRepository extends BaseRepository<Pedido,Long> {
    @Query("""
    SELECT\s
        am.id AS id,
        am.denominacion AS denominacion,
        am.precio_venta AS precioVenta,
        pd.cantidad AS cantidad,
        pd.subtotal AS subtotal
    FROM Pedido p
    JOIN p.detalles pd
    JOIN TREAT(pd.articulo AS ArticuloManufacturado) am
    WHERE p.id = :pedidoId
    
    UNION
    
    SELECT\s
        ai.id AS id,
        ai.denominacion AS denominacion,
        ai.precio_venta AS precioVenta,
        pd.cantidad AS cantidad,
        pd.subtotal AS subtotal
    FROM Pedido p
    JOIN p.detalles pd
    JOIN TREAT(pd.articulo AS ArticuloInsumo) ai
    WHERE p.id = :pedidoId AND ai.es_para_elaborar = false
    
""")
    List<ArticuloManufacturadoPedidoDTO> findAllArticuloManufacturadoByPedido(@Param("pedidoId") Long pedidoId);

    @Modifying
    @Transactional
    @Query("UPDATE Pedido p SET p.estado_pedido = :nuevoEstado " +
            "WHERE p.id = :id AND p.eliminado = false")
    void actualizarEstado(Long id, Estado nuevoEstado);
}
