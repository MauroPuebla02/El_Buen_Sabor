package ElBuenSabor.UTN.Service.Interface;

import ElBuenSabor.UTN.Models.DTO.ArticuloManufacturadoPedidoDTO;
import ElBuenSabor.UTN.Models.Model.Estado;
import ElBuenSabor.UTN.Models.Model.Pedido;
import ElBuenSabor.UTN.Service.iBaseService;

import java.util.List;

public interface iPedidoService extends iBaseService<Pedido, Long> {
    List<ArticuloManufacturadoPedidoDTO> findAllArticuloManufacturadoByPedido(Long pedidoId);

    void actualizarEstado(Long id, Estado nuevoEstado);
}
