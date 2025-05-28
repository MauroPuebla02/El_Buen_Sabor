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
public class Categoria extends EntityBean{
    private String denominacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_padre_id")
    private Categoria categoria_padre;

    @OneToMany(mappedBy = "categoria_padre", cascade = CascadeType.ALL)
    private List<Categoria> categorias_hijas = new ArrayList<>();

    @ManyToMany(mappedBy = "categorias")
    private List<Articulo> articulos;
}
