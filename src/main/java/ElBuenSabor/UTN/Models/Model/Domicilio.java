package ElBuenSabor.UTN.Models.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
public class Domicilio extends EntityBean{
    private String calle;
    private Integer numero,cp;

    @ManyToOne
    @JoinColumn(name = "localidad_id")
    private Localidad localidad;

    /*
    @ManyToMany(mappedBy = "domicilios")
    private List<Usuario> usuarios;
    */

}
