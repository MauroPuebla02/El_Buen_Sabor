package ElBuenSabor.UTN.Controller;

import ElBuenSabor.UTN.Models.ProjectionDTO.RendimientoChartProjectionDTOImpl;
import ElBuenSabor.UTN.Service.Implements.EstadisticasServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estadisticas")
public class EstadisticasController {

    private final EstadisticasServiceImpl estadisticasService;

    public EstadisticasController(EstadisticasServiceImpl estadisticasService) {
        this.estadisticasService = estadisticasService;
    }

    @GetMapping("/rendimiento")
    public RendimientoChartProjectionDTOImpl getRendimiento(@RequestParam int periodo) {
        return estadisticasService.getRendimientos(periodo);
    }

    @GetMapping("/productos_mas_vendidos")
    public List<List<Object>> getProductosMasVendidos(@RequestParam int periodo) {
        return estadisticasService.getProductosMasVendidos(periodo);
    }

    @GetMapping("/clientes_ranking")
    public List<List<Object>> getRankingClientes(@RequestParam int periodo) {
        return estadisticasService.getRankingClientes(periodo);
    }
}