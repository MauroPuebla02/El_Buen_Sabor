package ElBuenSabor.UTN.Service.Implements;

import ElBuenSabor.UTN.Models.Model.Domicilio;
import ElBuenSabor.UTN.Repository.BaseRepository;
import ElBuenSabor.UTN.Repository.DomicilioRepository;
import ElBuenSabor.UTN.Service.BaseServiceImpl;
import ElBuenSabor.UTN.Service.Interface.iDomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomicilioServiceImpl extends BaseServiceImpl<Domicilio, Long> implements iDomicilioService {
    @Autowired
    private DomicilioRepository repository;
    public DomicilioServiceImpl(BaseRepository<Domicilio, Long> baseRepository) {super(baseRepository);}

}
