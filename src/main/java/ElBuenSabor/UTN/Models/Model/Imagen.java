package ElBuenSabor.UTN.Models.Model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
public class Imagen extends EntityBean{

    @Lob
    @Column(name = "src", columnDefinition = "CLOB")
    private String src;

    private String alt;
}
