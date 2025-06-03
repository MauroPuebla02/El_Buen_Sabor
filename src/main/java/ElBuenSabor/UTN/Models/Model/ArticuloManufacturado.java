package ElBuenSabor.UTN.Models.Model;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
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

    @OneToMany(mappedBy = "articulo_manufacturado",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference("detalle-articulo")
    private List<ArticuloManufacturadoDetalle> detalles;

}
