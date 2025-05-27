package ElBuenSabor.UTN.Models.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
public class ArticuloManufacturado extends Articulo {
    private String descripcion,preparacion;
    private Integer tiempo_estimado_en_minutos;

    @OneToMany(mappedBy = "articuloManufacturado")
    private List<ArticuloManufacturadoDetalle> detalles;

}
