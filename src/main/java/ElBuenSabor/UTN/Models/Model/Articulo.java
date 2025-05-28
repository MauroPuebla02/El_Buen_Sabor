package ElBuenSabor.UTN.Models.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
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
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Articulo extends EntityBean{
    protected String denominacion;
    protected double precio_venta;

    @OneToOne
    @JoinColumn(name = "imagen_id")
    protected Imagen imagen;

    @ManyToOne
    @JoinColumn(name = "unidad_de_medida_id")
    private UnidadDeMedida unidad_de_medida;

    @ManyToMany
    @JoinTable(
            name = "categoria_articulo",
            joinColumns = @JoinColumn(name = "articulo_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    @JsonManagedReference("categoria-articulo")
    private List<Categoria> categorias;
}
