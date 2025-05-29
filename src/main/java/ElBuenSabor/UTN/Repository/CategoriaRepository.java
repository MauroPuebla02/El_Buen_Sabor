package ElBuenSabor.UTN.Repository;

import ElBuenSabor.UTN.Models.Model.Categoria;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoriaRepository extends BaseRepository<Categoria, Long>{


    @Query(value= """
    SELECT C.ID AS ID, C.DENOMINACION AS DENOMINACION FROM CATEGORIA AS C JOIN CATEGORIA_ARTICULO AS CA
        ON CA.CATEGORIA_ID = C.ID
        JOIN ARTICULO_MANUFACTURADO AS AM
        ON AM.ID = CA.ARTICULO_ID
        JOIN ARTICULO AS A
        ON A.ID = AM.ID WHERE A.ELIMINADO != TRUE AND C.ELIMINADO != TRUE
""", nativeQuery = true)
    List<Categoria> findByManufacturado();
}
