package ElBuenSabor.UTN.Controller;

import ElBuenSabor.UTN.Models.DTO.PedidoHistorialClienteDTO;
import ElBuenSabor.UTN.Models.Model.Pedido;
import ElBuenSabor.UTN.Service.Implements.PedidoServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
