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
import ElBuenSabor.UTN.Models.ProjectionDTO.ProductoChartProjectionDTO;
import ElBuenSabor.UTN.Models.ProjectionDTO.RendimientoChartProjectionDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PedidoRepository extends BaseRepository<Pedido,Long> {
    @Query(value = """
    SELECT p.*
    FROM pedido p
    JOIN pedido_detalle pd ON p.id = pd.pedido_id
    JOIN articulo a ON pd.articulo_id = a.id
    LEFT JOIN articulo_insumo ai ON a.id = ai.id
    LEFT JOIN stock_insumo_sucursal sis ON sis.articulo_insumo_id = ai.id
    LEFT JOIN articulo_manufacturado am ON a.id = am.id
    LEFT JOIN articulo_manufacturado_detalle amd ON am.id = amd.articulo_manufacturado_id
    LEFT JOIN articulo_insumo ai2 ON amd.articulo_insumo_id = ai2.id
    LEFT JOIN stock_insumo_sucursal sis2 ON ai2.id = sis2.articulo_insumo_id
    WHERE p.fecha_pedido BETWEEN :desde AND :hasta
""", nativeQuery = true)
   List<Pedido> findAllByFechaPedidoBetween(LocalDate desde, LocalDate hasta);

    @Query(value = """
    SELECT 
        COUNT(p.id) AS ventas,
        COALESCE(SUM(p.total - COALESCE(p.descuento, 0)), 0) AS ingresos,
        0 AS costos,
        COUNT(DISTINCT u.id) AS nuevosClientes
    FROM pedido p
    JOIN usuario u ON p.usuario_id = u.id
    WHERE p.fecha_pedido BETWEEN :desde AND :hasta
      AND u.rol = 'CLIENTE'
""", nativeQuery = true)
    RendimientoChartProjectionDTO getRendimientosSinCosto(@Param("desde")LocalDate desde, @Param("hasta") LocalDate hasta);
    @Query("""
    SELECT 
        am.id AS id,
        am.denominacion AS denominacion,
        am.precio_venta AS precioVenta,
        pd.cantidad AS cantidad,
        pd.subtotal AS subtotal
    FROM Pedido p
    JOIN p.detalles pd
    JOIN TREAT(pd.articulo AS ArticuloManufacturado) am
    WHERE p.id = :pedidoId
""")
    List<ArticuloManufacturadoPedidoDTO> findAllArticuloManufacturadoByPedido(@Param("pedidoId") Long pedidoId);

    @Query("""
    SELECT a.denominacion AS producto, SUM(d.cantidad) AS cantidadVendida
    FROM PedidoDetalle d
    JOIN d.articulo a
    JOIN d.pedido p
    WHERE p.fecha_pedido BETWEEN :desde AND :hasta
    GROUP BY a.id
    ORDER BY cantidadVendida DESC
""")
    List<ProductoChartProjectionDTO> getProductosMasVendidos(@Param("desde")LocalDate desde, @Param("hasta")LocalDate hasta, Pageable pageable);

    List<Pedido> findByUsuarioId(Long idCliente, Pageable pageable);
    @Modifying
    @Transactional
    @Query("UPDATE Pedido p SET p.estado_pedido = :nuevoEstado " +
            "WHERE p.id = :id AND p.eliminado = false")
    void actualizarEstado(Long id, Estado nuevoEstado);
}
