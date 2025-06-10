package ElBuenSabor.UTN.Service.Implements;

import ElBuenSabor.UTN.Models.Model.Factura;
import ElBuenSabor.UTN.Repository.BaseRepository;
import ElBuenSabor.UTN.Repository.FacturaRepository;
import ElBuenSabor.UTN.Service.BaseServiceImpl;
import ElBuenSabor.UTN.Service.Interface.iFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaServiceImpl extends BaseServiceImpl<Factura, Long> implements iFacturaService {
    @Autowired
    private FacturaRepository repository;
    public FacturaServiceImpl(BaseRepository<Factura, Long> baseRepository) {super(baseRepository);}
}
