package ElBuenSabor.UTN.Models.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
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
    private Integer mp_payment_id,mp_merchant_order_id;
    private String mp_preference_id,mp_payment_type;
    private double total_venta;
    private FormaPago forma_pago;

    @OneToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;
}
