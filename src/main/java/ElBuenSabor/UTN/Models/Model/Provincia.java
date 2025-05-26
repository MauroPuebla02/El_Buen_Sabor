package ElBuenSabor.UTN.Models.Model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
public class Provincia extends EntityBean {
    private String nombre;

    @OneToMany(mappedBy="provincia",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Localidad> localidad = new ArrayList<>();

    @ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
    @JoinColumn(name = "pais_id")
    private Pais pais;
}
