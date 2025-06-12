package ElBuenSabor.UTN.Models.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "articulo")
@SQLDelete(sql = "UPDATE articulo SET eliminado = true WHERE id = ?")
@Where(clause = "eliminado = false")
// Le decimos a Jackson que incluya un campo "_type" con el nombre de la subclase
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "_type"
)
// Registramos las dos subclases conocidas
@JsonSubTypes({
        @JsonSubTypes.Type(value = ArticuloManufacturado.class, name = "manufacturado"),
        @JsonSubTypes.Type(value = ArticuloInsumo.class,      name = "insumo")
})
public abstract class Articulo extends EntityBean{
    protected String denominacion;
    protected double precio_venta;

    @OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE },orphanRemoval = true)
    @JoinColumn(name = "imagen_id")
    protected Imagen imagen;

    @ManyToOne()
    @JoinColumn(name = "unidad_de_medida_id")
    private UnidadDeMedida unidad_de_medida;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Articulo(Long id) {
        this.id = id;
    }

}
