package ElBuenSabor.UTN.Models.Model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
@SQLDelete(sql    = "UPDATE promocion SET eliminado = true WHERE id = ?")
@Where(clause  = "eliminado = false")
public class Promocion extends EntityBean{
    private String denominacion,descripcion_descuento;
    private LocalDate fecha_desde,fecha_hasta;
    private LocalTime hora_desde,hora_hasta;
    private double precio_promocional;

    @ManyToOne
    @JoinColumn(name = "tipo_promocion_id")
    private TipoPromocion tipo_promocion;

    @ManyToMany(mappedBy = "promociones")
    private List<Sucursal> sucursales;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "promocion_articulo",
            joinColumns = @JoinColumn(name = "promocion_id"),
            inverseJoinColumns = @JoinColumn(name = "articulo_id")
    )
    private List<Articulo> articulos;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "imagen_id")
    private Imagen imagen;

}
