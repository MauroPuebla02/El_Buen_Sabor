package ElBuenSabor.UTN.Models.Model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
public class ArticuloManufacturadoDetalle extends EntityBean{
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "articulo_manufacturado_id")
    @JsonBackReference("detalle-articulo")
    private ArticuloManufacturado articulo_manufacturado;

    @ManyToOne
    @JoinColumn(name = "articulo_insumo_id")
    private ArticuloInsumo articulo_insumo;
}
