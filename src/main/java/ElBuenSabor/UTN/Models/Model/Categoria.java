package ElBuenSabor.UTN.Models.Model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
public class Categoria extends EntityBean{
    private String denominacion;

    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name = "categoria_id")
    @Builder.Default
    private List<Categoria> categorias_hijas = new ArrayList<>();



    @ManyToOne
    @JoinColumn(name = "tipo_categoria_id")
    private TipoCategoria tipo_categoria;
}
