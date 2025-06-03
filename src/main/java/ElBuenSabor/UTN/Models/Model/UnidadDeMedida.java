package ElBuenSabor.UTN.Models.Model;
import jakarta.persistence.Entity;
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
@Table(name = "unidad_de_medida")
@SQLDelete(sql = "UPDATE unidad_de_medida SET eliminado = true WHERE id = ?")
@Where(clause = "eliminado = false")
public class UnidadDeMedida extends EntityBean{
    private String denominacion;

}
