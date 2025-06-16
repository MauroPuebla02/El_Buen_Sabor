package ElBuenSabor.UTN.Controller;

import ElBuenSabor.UTN.Models.DTO.PedidoHistorialClienteDTO;
import ElBuenSabor.UTN.Models.DTO.ArticuloManufacturadoPedidoDTO;
import ElBuenSabor.UTN.Models.DTO.EstadoUpdateRequestDTO;
import ElBuenSabor.UTN.Models.Model.Pedido;
import ElBuenSabor.UTN.Service.Implements.PedidoServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/pedidos")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoServiceImpl>{
    public PedidoController(PedidoServiceImpl service) {super(service);}

    @GetMapping(value = "/byClientes/{idCliente}")
    public List<PedidoHistorialClienteDTO> getPedidoPorClientePaginado(
            @PathVariable Long idCliente,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "16") int size) {
        return service.getPedidosPorClientePaginado(idCliente, page, size);
    }

    @GetMapping(value = "/manufacturados/{pedidoId}")
    public List<ArticuloManufacturadoPedidoDTO> findAllArticuloManufacturadoByPedido(@PathVariable("pedidoId") Long pedidoId){
        return  service.findAllArticuloManufacturadoByPedido(pedidoId);
    }

    @PatchMapping("/pedido/{pedidoId}")
    public ResponseEntity<?> actualizarEstado(@PathVariable("pedidoId") Long id,
                                                   @RequestBody EstadoUpdateRequestDTO dto) {
        service.actualizarEstado(id, dto.getEstadoPedido());
        return ResponseEntity.ok().build();
    }
}
