package ElBuenSabor.UTN.Service.Interface;

import ElBuenSabor.UTN.Models.ProjectionDTO.RendimientoChartProjectionDTO;

import java.util.List;

public interface iEstadisticasService {
    RendimientoChartProjectionDTO getRendimientos(int periodo);
    List<List<Object>> getProductosMasVendidos(int periodo);
    List<List<Object>> getRankingClientes(int periodo);
}
