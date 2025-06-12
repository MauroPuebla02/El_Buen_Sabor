package ElBuenSabor.UTN.Models.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
public class Factura extends EntityBean{
    private LocalDate fecha_facturacion;

    private String mp_preference_id;
    private double total_venta;
    private FormaPago forma_pago;

    @OneToOne(mappedBy = "factura")
    private Pedido pedido;
}
