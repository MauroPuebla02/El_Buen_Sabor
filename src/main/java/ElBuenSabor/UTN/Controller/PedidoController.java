package ElBuenSabor.UTN.Controller;

import ElBuenSabor.UTN.Models.Model.ArticuloInsumo;
import ElBuenSabor.UTN.Models.Model.Pedido;
import ElBuenSabor.UTN.Service.Implements.ArticuloInsumoServiceImpl;
import ElBuenSabor.UTN.Service.Implements.PedidoServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pedidos")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoServiceImpl>{

    public PedidoController(PedidoServiceImpl service) {
        super(service);
    }
}
