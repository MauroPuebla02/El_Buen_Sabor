package ElBuenSabor.UTN.Models.Model;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
@Table(name = "articulo_manufacturado")
@SQLDelete(sql = "UPDATE articulo_manufacturado SET eliminado = true WHERE id = ?")
@Where(clause = "eliminado = false")
public class ArticuloManufacturado extends Articulo {
    @Column(name = "eliminado")
    boolean delete = false;
    @Lob
    @Column(columnDefinition = "TEXT", nullable = true)
    private String descripcion;

    @Lob
    @Column(columnDefinition = "TEXT", nullable = true)
    private String preparacion;

    private Integer tiempo_estimado_en_minutos;

    @OneToMany(mappedBy = "articulo_manufacturado",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference("detalle-articulo")
    private List<ArticuloManufacturadoDetalle> detalles;

}
