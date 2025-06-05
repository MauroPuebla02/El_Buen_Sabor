package ElBuenSabor.UTN.Controller;

import ElBuenSabor.UTN.Models.Model.Pedido;
import ElBuenSabor.UTN.Service.Implements.PedidoServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pedidos")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoServiceImpl>{
    public PedidoController(PedidoServiceImpl service) {super(service);}
}
