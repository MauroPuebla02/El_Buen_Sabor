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
@Table(name = "articulo_insumo")
@SQLDelete(sql = "UPDATE articulo_insumo SET eliminado = true WHERE id = ?")
@Where(clause = "eliminado = false")
public class ArticuloInsumo extends Articulo {
    @Column(name = "eliminado")
    boolean delete = false;

    private boolean es_para_elaborar;

    @OneToMany(
            mappedBy = "articulo_insumo",
            cascade   = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    @JsonManagedReference
    private List<StockInsumoSucursal> stock_insumo_sucursales;
}
