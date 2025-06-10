package ElBuenSabor.UTN.Service.Implements;

import ElBuenSabor.UTN.Models.DTO.CategoriaByManufactoradoDTO;
import ElBuenSabor.UTN.Models.Model.Categoria;
import ElBuenSabor.UTN.Repository.BaseRepository;
import ElBuenSabor.UTN.Repository.CategoriaRepository;
import ElBuenSabor.UTN.Service.BaseServiceImpl;
import ElBuenSabor.UTN.Service.Interface.iCategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl extends BaseServiceImpl<Categoria, Long>  implements iCategoriaService {
    @Autowired
    private CategoriaRepository repository;

    public CategoriaServiceImpl(BaseRepository <Categoria,Long>baseRepository) {super(baseRepository); }

    public List<Categoria> findCategoriaParaVentas() {
        return repository.findCategoriaParaVentas();
    }

    public List<Categoria> findByCategoriaPadreIsNull() {
        return repository.findByCategoriaPadreIsNull();
    }

    public List<Categoria> findByTipoCategoria(Long idTipoCategoria) {
        return repository.findByTipoCategoria(idTipoCategoria);
    }
}
