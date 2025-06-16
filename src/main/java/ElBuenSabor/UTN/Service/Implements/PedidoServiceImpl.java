package ElBuenSabor.UTN.Service.Implements;

import ElBuenSabor.UTN.Models.DTO.ArticuloManufacturadoPedidoDTO;
import ElBuenSabor.UTN.Models.Model.ArticuloManufacturado;
import ElBuenSabor.UTN.Models.Model.Estado;
import ElBuenSabor.UTN.Models.Model.Pedido;
import ElBuenSabor.UTN.Repository.BaseRepository;
import ElBuenSabor.UTN.Repository.PedidoRepository;
import ElBuenSabor.UTN.Service.BaseServiceImpl;
import ElBuenSabor.UTN.Service.Interface.iPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido, Long> implements iPedidoService {
    @Autowired
    private PedidoRepository repository;
    public PedidoServiceImpl(BaseRepository<Pedido, Long> baseRepository) {super(baseRepository);}

    public List<ArticuloManufacturadoPedidoDTO> findAllArticuloManufacturadoByPedido(Long pedidoId) {
        return repository.findAllArticuloManufacturadoByPedido(pedidoId);
    }


    public void actualizarEstado(Long id, Estado nuevoEstado) {

         repository.actualizarEstado(id,nuevoEstado);
    }
}
