package ElBuenSabor.UTN.Models.ProjectionDTO;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.math.BigDecimal;

public class RendimientoChartProjectionDTOImpl implements RendimientoChartProjectionDTO {
    private final int ventas;
    @JsonSerialize(using = BigDecimalToPlainStringSerializer.class)
    private final BigDecimal ingresos;
    @JsonSerialize(using = BigDecimalToPlainStringSerializer.class)
    private final BigDecimal costos;
    private final int nuevosClientes;

    public RendimientoChartProjectionDTOImpl(int ventas, BigDecimal ingresos, BigDecimal costos, int nuevosClientes) {
        this.ventas = ventas;
        this.ingresos = ingresos;
        this.costos = costos;
        this.nuevosClientes = nuevosClientes;
    }

    @Override public int getVentas() { return ventas; }
    @Override public BigDecimal  getIngresos() { return ingresos; }
    @Override public BigDecimal  getCostos() { return costos; }
    @Override public int getNuevosClientes() { return nuevosClientes; }
}
