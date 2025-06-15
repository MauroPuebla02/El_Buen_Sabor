package ElBuenSabor.UTN.Service.Implements;

import ElBuenSabor.UTN.Models.Model.*;
import ElBuenSabor.UTN.Models.ProjectionDTO.ClienteRankingProjectionDTO;
import ElBuenSabor.UTN.Models.ProjectionDTO.ProductoChartProjectionDTO;
import ElBuenSabor.UTN.Models.ProjectionDTO.RendimientoChartProjectionDTO;
import ElBuenSabor.UTN.Models.ProjectionDTO.RendimientoChartProjectionDTOImpl;
import ElBuenSabor.UTN.Repository.PedidoRepository;
import ElBuenSabor.UTN.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EstadisticasServiceImpl {
    @Autowired
    private final PedidoRepository pedidoRepository;
    private final UsuarioRepository usuarioRepository;
    public EstadisticasServiceImpl(PedidoRepository pedidoRepository, UsuarioRepository usuarioRepository){
        this.pedidoRepository = pedidoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public RendimientoChartProjectionDTOImpl getRendimientos(int periodo) {
        LocalDate desde = calcularFechaDesde(periodo);
        LocalDate hasta = calcularFechaDesde(1);
        RendimientoChartProjectionDTO dto = pedidoRepository.getRendimientosSinCosto(desde,hasta);
        BigDecimal costo = calcularCostos(desde, hasta);
        return new RendimientoChartProjectionDTOImpl(
                dto.getVentas(),
                dto.getIngresos(),
                costo,
                dto.getNuevosClientes()
        );

    }

    public List<List<Object>> getProductosMasVendidos(int periodo) {
        List<List<Object>> data = new ArrayList<>();
        LocalDate desde = calcularFechaDesde(periodo);
        LocalDate hasta = calcularFechaDesde(1);
        Pageable top50 = PageRequest.of(0, 50); // página 0, tamaño 50
        data.add(Arrays.asList("Articulo", "Cantidad Vendida")); // header
        List<ProductoChartProjectionDTO> resultados = pedidoRepository.getProductosMasVendidos(desde, hasta,top50);
        for (ProductoChartProjectionDTO r : resultados) {
            data.add(Arrays.asList(r.getProducto(), r.getCantidadVendida()));
        }
        return data;
    }

    public List<List<Object>> getRankingClientes(int periodo) {
        List<List<Object>> data = new ArrayList<>();
        LocalDate desde = calcularFechaDesde(periodo);
        LocalDate hasta = calcularFechaDesde(1);
        Pageable top50 = PageRequest.of(0, 50); // página 0, tamaño 50

        List<ClienteRankingProjectionDTO> resultados = usuarioRepository.getRankingClientes(desde, hasta, top50);
        for (ClienteRankingProjectionDTO r : resultados) {
            data.add(Arrays.asList(r.getCliente(), r.getPedidos(), r.getTotal()));
        }
        return data;
    }

    public LocalDate calcularFechaDesde(int periodo) {
        LocalDate hoy = LocalDate.now();
        return switch (periodo) {
            case 1 -> hoy;                                      // Día
            case 2 -> hoy.minusWeeks(1);         // Semana
            case 3 -> hoy.minusMonths(1);       // Mes
            default -> throw new IllegalArgumentException("Periodo inválido: " + periodo);
        };
    }

    private BigDecimal calcularCostos(LocalDate desde, LocalDate hasta) {
        List<Pedido> pedidos = pedidoRepository.findAllByFechaPedidoBetween(desde, hasta);
        BigDecimal totalCosto = BigDecimal.ZERO;

        for (Pedido pedido : pedidos) {
            for (PedidoDetalle detalle : pedido.getDetalles()) {
                Articulo articulo = detalle.getArticulo();

                if (articulo instanceof ArticuloInsumo insumo) {
                    totalCosto = totalCosto.add(
                            insumo.getStock_insumo_sucursales().stream()
                                    .findFirst()
                                    .map(s -> s.getPrecio_compra().multiply(BigDecimal.valueOf(detalle.getCantidad())))
                                    .orElse(BigDecimal.ZERO)
                    );
                } else if (articulo instanceof ArticuloManufacturado manu) {
                    for (ArticuloManufacturadoDetalle det : manu.getDetalles()) {
                        ArticuloInsumo insumo = det.getArticulo_insumo();
                        BigDecimal cantidad = BigDecimal.valueOf(det.getCantidad())
                                .multiply(BigDecimal.valueOf(detalle.getCantidad()));

                        totalCosto = totalCosto.add(
                                insumo.getStock_insumo_sucursales().stream()
                                        .findFirst()
                                        .map(s -> s.getPrecio_compra().multiply(cantidad))
                                        .orElse(BigDecimal.ZERO)
                        );
                    }
                }
            }
        }

        return totalCosto;
    }
}