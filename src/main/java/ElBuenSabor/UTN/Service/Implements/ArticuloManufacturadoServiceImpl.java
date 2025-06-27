package ElBuenSabor.UTN.Service.Implements;

import ElBuenSabor.UTN.Models.Model.Articulo;
import ElBuenSabor.UTN.Models.Model.ArticuloManufacturado;
import ElBuenSabor.UTN.Repository.ArticuloInsumoRepository;
import ElBuenSabor.UTN.Repository.ArticuloManufacturadoRepository;
import ElBuenSabor.UTN.Repository.BaseRepository;
import ElBuenSabor.UTN.Service.BaseServiceImpl;
import ElBuenSabor.UTN.Service.Interface.iArticuloManufacturadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticuloManufacturadoServiceImpl extends BaseServiceImpl<ArticuloManufacturado, Long> implements iArticuloManufacturadoService {

    @Autowired
    private ArticuloManufacturadoRepository repository;
    @Autowired
    private ArticuloInsumoRepository repositoryInsumo;
    public ArticuloManufacturadoServiceImpl(BaseRepository<ArticuloManufacturado,Long> baseRepository) {super(baseRepository); }


    public List<ArticuloManufacturado> findArticulosManufacturadosByCategoria(Long idCategoria) {
        return repository.findArticulosManufacturadosByCategoria(idCategoria);
    }

    public ArticuloManufacturado getArticuloManufacturadoPorId(Long id) {
        return repository.getArticuloManufacturadoPorId(id);
    }

    public List<Articulo> findArticulosManufacturadoConInsumos() {
        List<Articulo> lista = new ArrayList<>();
        lista.addAll(repository.findAll());
        lista.addAll(repositoryInsumo.findAllInsumoNoElaborar());
        return lista;
    }
}
