package ElBuenSabor.UTN.Models.Model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
public class Usuario extends EntityBean{
    private String nombre,apellido,telefono,email,Password;
    private LocalDate fecha_nacimiento;
    @Enumerated(EnumType.STRING)
    private Rol rol;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuario_domicilio",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "domicilio_id")
    )
    private List<Domicilio> domicilios;

    @ManyToMany(mappedBy = "usuarios")
    private List<Sucursal> sucursales;

    @OneToOne
    @JoinColumn(name = "usuario_a0_id")
    private UsuarioA0 usuario_A0;

    @OneToOne
    @JoinColumn(name = "imagen_id")
    private Imagen imagen;

    @OneToMany(mappedBy = "usuario")
    private List<Pedido> pedidos;

}
