package ElBuenSabor.UTN.Models.Model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
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
@Table(name = "categoria")
@SQLDelete(sql = "UPDATE categoria SET eliminado = true WHERE id = ?")
@Where(clause = "eliminado = false")
public class Categoria extends EntityBean{
    private String denominacion;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id")
    @Builder.Default
    private List<Categoria> categorias_hijas = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "tipo_categoria_id")
    private TipoCategoria tipo_categoria;
}
