package ElBuenSabor.UTN.Models.Model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
@Table(name = "articulo_manufacturado_detalle")
@SQLDelete(sql = "UPDATE articulo_manufacturado_detalle SET eliminado = true WHERE id = ?")
@Where(clause = "eliminado = false")
public class ArticuloManufacturadoDetalle extends EntityBean{
    private double cantidad;

    @ManyToOne
    @JoinColumn(name = "articulo_manufacturado_id")
    @JsonBackReference("detalle-articulo")
    private ArticuloManufacturado articulo_manufacturado;

    @ManyToOne
    @JoinColumn(name = "articulo_insumo_id")
    private ArticuloInsumo articulo_insumo;
}
