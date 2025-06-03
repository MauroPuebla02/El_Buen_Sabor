package ElBuenSabor.UTN.Service.Implements;

import ElBuenSabor.UTN.Models.Model.UnidadDeMedida;
import ElBuenSabor.UTN.Repository.BaseRepository;
import ElBuenSabor.UTN.Repository.UnidadDeMedidaRepository;
import ElBuenSabor.UTN.Service.BaseServiceImpl;
import ElBuenSabor.UTN.Service.Interface.iUnidadDeMedidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnidadDeMedidaServiceImpl extends BaseServiceImpl<UnidadDeMedida, Long> implements iUnidadDeMedidaService{

    @Autowired
    private UnidadDeMedidaRepository repository;
    public UnidadDeMedidaServiceImpl(BaseRepository<UnidadDeMedida,Long> baseRepository){super(baseRepository);}
}
