package ElBuenSabor.UTN.Repository;

import ElBuenSabor.UTN.Models.Model.ArticuloInsumo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloInsumoRepository extends BaseRepository<ArticuloInsumo, Long> {
/*
    @Query(value = """
            SELECT * FROM ARTICULO_INSUMO
        """,
            nativeQuery = true)
    List<ArticuloInsumo> findArticulosInsumosByCategoria(Long idCategoria);

 */
}
