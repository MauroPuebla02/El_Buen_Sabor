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
public class ArticuloInsumo extends Articulo {
    private boolean es_para_elaborar;

    @OneToMany(mappedBy = "articulo_insumo")
    private List<StockInsumoSucursal> stock_insumo_sucursales;
}
