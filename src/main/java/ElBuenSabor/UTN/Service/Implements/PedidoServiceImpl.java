package ElBuenSabor.UTN.Service.Implements;

import ElBuenSabor.UTN.Models.Model.Pedido;
import ElBuenSabor.UTN.Repository.BaseRepository;
import ElBuenSabor.UTN.Repository.PedidoRepository;
import ElBuenSabor.UTN.Service.BaseServiceImpl;
import ElBuenSabor.UTN.Service.Interface.iPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido, Long> implements iPedidoService {
    @Autowired
    private PedidoRepository repository;
    public PedidoServiceImpl(BaseRepository<Pedido, Long> baseRepository) {super(baseRepository);}
}
