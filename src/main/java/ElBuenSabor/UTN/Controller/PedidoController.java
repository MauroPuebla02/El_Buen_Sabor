package ElBuenSabor.UTN.Controller;

import ElBuenSabor.UTN.Models.DTO.*;
import ElBuenSabor.UTN.Models.Model.Pedido;
import ElBuenSabor.UTN.Models.Model.Usuario;
import ElBuenSabor.UTN.Service.Implements.PedidoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/pedidos")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoServiceImpl>{
    private final SimpMessagingTemplate messagingTemplate;
    @Autowired
    public PedidoController(PedidoServiceImpl service, SimpMessagingTemplate messagingTemplate) {super(service);this.messagingTemplate = messagingTemplate;}

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
    public ResponseEntity<?> actualizarEstado(@PathVariable Long pedidoId,
                                              @RequestBody EstadoUpdateRequestDTO req) {
        service.actualizarEstado(pedidoId, req.getEstadoPedido());

        Pedido pedido = service.findById(pedidoId);
        PedidoEstadoDTO dto = service.toEstadoDTO(pedido);

        // 3) Broadcast a todos los empleados
        messagingTemplate.convertAndSend("/topic/pedidos", dto);

        // 4) Notificación solo al cliente que creó el pedido
        Long clienteId = pedido.getUsuario().getId();
        messagingTemplate.convertAndSend("/topic/pedidos/cliente/" + clienteId, dto);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/pedido/repartidor")
    public ResponseEntity<?> actualizarRepartidor(@RequestBody UpdatePedidoDTO dto) {
        service.actualizarDelivery(dto.getIdPedido(), dto.getIdDelivery());
        return ResponseEntity.ok().build();
    }

}
