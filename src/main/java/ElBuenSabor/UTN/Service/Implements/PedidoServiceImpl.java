package ElBuenSabor.UTN.Service.Implements;

import ElBuenSabor.UTN.Models.DTO.PedidoEstadoDTO;
import ElBuenSabor.UTN.Models.DTO.PedidoHistorialClienteDTO;
import ElBuenSabor.UTN.Models.DTO.ArticuloManufacturadoPedidoDTO;
import ElBuenSabor.UTN.Models.Model.Estado;
import ElBuenSabor.UTN.Models.Model.Pedido;
import ElBuenSabor.UTN.Models.Mappers.PedidoHistorialClienteMapper;
import ElBuenSabor.UTN.Repository.BaseRepository;
import ElBuenSabor.UTN.Repository.PedidoRepository;
import ElBuenSabor.UTN.Service.BaseServiceImpl;
import ElBuenSabor.UTN.Service.Interface.iPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido, Long> implements iPedidoService {
    @Autowired
    private PedidoRepository repository;
    private final PedidoHistorialClienteMapper pedidoMapper;
    public PedidoServiceImpl(BaseRepository<Pedido, Long> baseRepository, PedidoHistorialClienteMapper pedidoMapper) {
        super(baseRepository);
        this.pedidoMapper = pedidoMapper;
    }

    public List<PedidoHistorialClienteDTO> getPedidosPorClientePaginado(Long idCliente, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<Pedido> pedidos = repository.findByUsuarioId(idCliente, pageable);
        return pedidoMapper.toHistorialDTOList(pedidos);
    }

    public List<ArticuloManufacturadoPedidoDTO> findAllArticuloManufacturadoByPedido(Long pedidoId) {
        return repository.findAllArticuloManufacturadoByPedido(pedidoId);
    }

    public void actualizarEstado(Long id, Estado nuevoEstado) {

         repository.actualizarEstado(id,nuevoEstado);
    }
    public void actualizarDelivery(Long id, Long idDelivery) {

        repository.actualizarDelivery(id,idDelivery);
    }

    public PedidoEstadoDTO toEstadoDTO(Pedido p) {
        return new PedidoEstadoDTO(
                p.getId(),
                p.getEstado_pedido(),
                LocalDateTime.now()   // sólo para notificación
        );
    }
}
