package ElBuenSabor.UTN.Service.Implements;

import ElBuenSabor.UTN.Models.Model.Promocion;
import ElBuenSabor.UTN.Repository.BaseRepository;
import ElBuenSabor.UTN.Repository.PromocionRepository;
import ElBuenSabor.UTN.Service.BaseServiceImpl;
import ElBuenSabor.UTN.Service.Interface.iPromocionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromocionServiceImpl extends BaseServiceImpl<Promocion, Long> implements iPromocionService {
    @Autowired
    private PromocionRepository repository;
    public PromocionServiceImpl(BaseRepository<Promocion, Long> baseRepository) {super(baseRepository);}
}
