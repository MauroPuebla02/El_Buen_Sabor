package ElBuenSabor.UTN.Models.ProjectionDTO;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigDecimal;

public interface ClienteRankingProjectionDTO {
    String getCliente();
    int getPedidos();
    @JsonSerialize(using = BigDecimalToPlainStringSerializer.class)
    BigDecimal getTotal();
}
