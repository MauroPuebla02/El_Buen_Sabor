package ElBuenSabor.UTN.Service.Implements;

import ElBuenSabor.UTN.Models.Model.ArticuloInsumo;
import ElBuenSabor.UTN.Repository.ArticuloInsumoRepository;
import ElBuenSabor.UTN.Repository.BaseRepository;
import ElBuenSabor.UTN.Service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ElBuenSabor.UTN.Service.Interface.iArticuloInsumoService;

import java.util.List;

@Service
public class ArticuloInsumoServiceImpl extends BaseServiceImpl<ArticuloInsumo, Long> implements iArticuloInsumoService{

    @Autowired
    private ArticuloInsumoRepository repository;
    public ArticuloInsumoServiceImpl(BaseRepository<ArticuloInsumo,Long> baseRepository) {super(baseRepository); }

    public List<ArticuloInsumo> findArticulosInsumosByCategoria(Long idCategoria){
        return repository.findArticulosInsumosByCategoria(idCategoria);
    }

    public void actualizarStock(Long insumoId, Long sucursalId, double nuevoStock) {
        repository.actualizarStock(insumoId, sucursalId, nuevoStock);
    }

}
