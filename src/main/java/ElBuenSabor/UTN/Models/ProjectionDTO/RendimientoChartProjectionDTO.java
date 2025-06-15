package ElBuenSabor.UTN.Models.ProjectionDTO;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.math.BigDecimal;

public interface RendimientoChartProjectionDTO {
    int getVentas();
    BigDecimal  getIngresos();
    BigDecimal  getCostos();
    int getNuevosClientes();
}
