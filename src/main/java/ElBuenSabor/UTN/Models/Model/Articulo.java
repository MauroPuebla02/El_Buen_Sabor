package ElBuenSabor.UTN.Models.Model;

import jakarta.persistence.*;
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

}
