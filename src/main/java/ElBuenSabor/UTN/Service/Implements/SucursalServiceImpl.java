package ElBuenSabor.UTN.Service.Implements;

import ElBuenSabor.UTN.Models.Model.Sucursal;
import ElBuenSabor.UTN.Repository.BaseRepository;
import ElBuenSabor.UTN.Repository.SucursalRepository;
import ElBuenSabor.UTN.Service.BaseServiceImpl;
import ElBuenSabor.UTN.Service.Interface.iSucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SucursalServiceImpl extends BaseServiceImpl<Sucursal, Long> implements iSucursalService {
    @Autowired
    private SucursalRepository repository;
    public SucursalServiceImpl(BaseRepository<Sucursal, Long> baseRepository) {super(baseRepository);}
}
