package ElBuenSabor.UTN.Service.Implements;

import ElBuenSabor.UTN.Models.DTO.ArticuloManufacturadoByCategoriaDTO;
import ElBuenSabor.UTN.Models.Model.ArticuloManufacturado;
import ElBuenSabor.UTN.Repository.ArticuloManufacturadoRepository;
import ElBuenSabor.UTN.Repository.BaseRepository;
import ElBuenSabor.UTN.Service.BaseServiceImpl;
import ElBuenSabor.UTN.Service.Interface.iArticuloManufacturadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloManufacturadoServiceImpl extends BaseServiceImpl<ArticuloManufacturado, Long> implements iArticuloManufacturadoService {
    @Autowired
    private ArticuloManufacturadoRepository repository;
    public ArticuloManufacturadoServiceImpl(BaseRepository<ArticuloManufacturado,Long> baseRepository) {super(baseRepository); }


    public List<ArticuloManufacturadoByCategoriaDTO> findArticulosManufacturadosByCategoria(Long idCategoria) {
        return repository.findArticulosManufacturadosByCategoria(idCategoria);
    }
}
