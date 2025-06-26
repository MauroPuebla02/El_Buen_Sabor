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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "promocion_detalle")
@SQLDelete(sql    = "UPDATE promocion_detalle SET eliminado = true WHERE id = ?")
@Where(clause  = "eliminado = false")
public class PromocionDetalle extends EntityBean{
    private int cantidad;

    @ManyToOne
    @JoinColumn(name ="promocion_id")
    @JsonBackReference
    private Promocion promocion;

    @ManyToOne
    @JoinColumn(name = "articulo_id")
    private Articulo articulo;
}
