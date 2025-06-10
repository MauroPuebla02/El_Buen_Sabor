package ElBuenSabor.UTN.Service.Implements;

import ElBuenSabor.UTN.Models.Model.TipoPromocion;
import ElBuenSabor.UTN.Repository.BaseRepository;
import ElBuenSabor.UTN.Repository.TipoPromocionRepository;
import ElBuenSabor.UTN.Service.BaseServiceImpl;
import ElBuenSabor.UTN.Service.Interface.iTipoPromocionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoPromocionServiceImpl extends BaseServiceImpl<TipoPromocion, Long> implements iTipoPromocionService {
    @Autowired
    private TipoPromocionRepository repository;
    public TipoPromocionServiceImpl(BaseRepository<TipoPromocion, Long> baseRepository) {super(baseRepository);}
}
