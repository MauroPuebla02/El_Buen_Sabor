package ElBuenSabor.UTN.Repository;

import ElBuenSabor.UTN.Models.Model.Usuario;
import ElBuenSabor.UTN.Models.ProjectionDTO.ClienteRankingProjectionDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario, Long> {
    @Query("""
    SELECT 
        CONCAT(u.nombre, ' ', u.apellido) AS cliente,
        COUNT(p.id) AS pedidos,
        SUM(p.total - COALESCE(p.descuento, 0)) AS total
    FROM Pedido p
    JOIN p.usuario u
    WHERE p.fecha_pedido BETWEEN :desde AND :hasta
      AND u.rol = 'CLIENTE'
    GROUP BY u.id
    ORDER BY pedidos DESC
""")
    List<ClienteRankingProjectionDTO> getRankingClientes(LocalDate desde, LocalDate hasta, Pageable pageable);
}
