package ElBuenSabor.UTN.Service.Implements;

import ElBuenSabor.UTN.Models.Model.TipoCategoria;
import ElBuenSabor.UTN.Repository.BaseRepository;
import ElBuenSabor.UTN.Repository.TipoCategoriaRepository;
import ElBuenSabor.UTN.Service.BaseServiceImpl;
import ElBuenSabor.UTN.Service.Interface.iTipoCategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoCategoriaServiceImpl extends BaseServiceImpl<TipoCategoria, Long> implements iTipoCategoriaService{

    @Autowired
    public TipoCategoriaRepository repository;

    public TipoCategoriaServiceImpl(BaseRepository<TipoCategoria,Long> baseRepository) {super(baseRepository);}
}
