package ElBuenSabor.UTN.Service.Interface;

import ElBuenSabor.UTN.Models.DTO.PedidoHistorialClienteDTO;
import ElBuenSabor.UTN.Models.Model.Pedido;
import ElBuenSabor.UTN.Service.iBaseService;

import java.util.List;

public interface iPedidoService extends iBaseService<Pedido, Long> {
    List<PedidoHistorialClienteDTO> getPedidosPorClientePaginado(Long idCliente, int page, int size);
}
