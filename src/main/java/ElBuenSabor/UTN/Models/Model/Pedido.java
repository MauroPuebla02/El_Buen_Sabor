package ElBuenSabor.UTN.Models.Model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
public class Pedido extends EntityBean{
    private LocalTime hora_estimada_finalizacion;
    private double total;
    private Estado estado_pedido;
    private TipoEnvio tipo_envio;
    @Column(columnDefinition = "FLOAT DEFAULT 0")
    private double descuento;
    private FormaPago forma_pago;
    private LocalDate fecha_pedido;

    @ManyToOne
    @JoinColumn(name = "domicilio_id")
    private Domicilio domicilio;

    @ManyToOne
    @JoinColumn(name = "sucursal_id")
    private Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "pedido",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonManagedReference("detalle-pedido")
    private List<PedidoDetalle> detalles;

    @ManyToOne
    @JoinColumn(name = "repartidor_id")
    private Usuario repartidor;
}
