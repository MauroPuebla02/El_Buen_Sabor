package ElBuenSabor.UTN.Models.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
public class Empresa extends EntityBean {

    private String nombre,razon_social,cuil;

    @OneToMany(mappedBy = "empresa")
    private List<Sucursal> sucursales;
}
