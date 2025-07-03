package ElBuenSabor.UTN.Models.Model;
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
@SQLDelete(sql = "UPDATE domicilio SET eliminado = true WHERE id = ?")
@Where(clause = "eliminado = false")
public class Domicilio extends EntityBean{
    private String calle,tipo;
    private Integer numero,cp;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "localidad_id")
    private Localidad localidad;

}
