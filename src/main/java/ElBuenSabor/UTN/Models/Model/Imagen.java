package ElBuenSabor.UTN.Models.Model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
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
@Table(name = "imagen")
@SQLDelete(sql = "UPDATE imagen SET eliminado = true WHERE id = ?")
@Where(clause = "eliminado = false")
public class Imagen extends EntityBean{

    @Lob
    @Column(name = "src", columnDefinition = "CLOB")
    private String src;

    private String alt;
}
