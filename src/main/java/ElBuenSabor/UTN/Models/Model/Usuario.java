package ElBuenSabor.UTN.Models.Model;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
@SQLDelete(sql = "UPDATE usuario SET eliminado = true WHERE id = ?")
@Where(clause = "eliminado = false")
public class Usuario extends EntityBean{
    private String nombre,apellido,telefono,email,Password;
    private LocalDate fecha_nacimiento;
    @Enumerated(EnumType.STRING)
    private Rol rol;

    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade ={CascadeType.MERGE }
    )
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

    @OneToOne(fetch = FetchType.EAGER,
            cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "imagen_id")
    private Imagen imagen;

    @OneToMany(mappedBy = "usuario")
    private List<Pedido> pedidos;

}
