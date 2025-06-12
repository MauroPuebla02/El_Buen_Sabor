package ElBuenSabor.UTN.Models.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Setter

@SuperBuilder
@Entity
public class DatosMercadoPago extends EntityBean {
    private String preferenceId;
    private String status;
    private String paymentId;
    private BigDecimal amount;
    private LocalDateTime date;
    @OneToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;


}
