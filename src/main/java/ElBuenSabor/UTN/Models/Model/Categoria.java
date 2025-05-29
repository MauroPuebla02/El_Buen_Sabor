package ElBuenSabor.UTN.Models.Model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ManyToOne()
    @JoinColumn(name = "categoria_padre_id")
    private Categoria categoria_padre;

    @ManyToMany(mappedBy = "categorias")
    @JsonBackReference("categoria-articulo")
    private List<Articulo> articulos;
}
