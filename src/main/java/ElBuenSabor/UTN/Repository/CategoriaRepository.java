package ElBuenSabor.UTN.Repository;

import ElBuenSabor.UTN.Models.Model.Categoria;
import ElBuenSabor.UTN.Models.Model.TipoCategoria;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoriaRepository extends BaseRepository<Categoria, Long>{

    @Query("""
      SELECT DISTINCT c
        FROM Categoria c
   LEFT JOIN FETCH c.categorias_hijas h
       WHERE c.id NOT IN (
         SELECT hc.id
           FROM Categoria parent
           JOIN parent.categorias_hijas hc
       ) AND c.eliminado = FALSE AND c.tipo_categoria.id = 2
      """)
    List<Categoria> findByCategoriaPadreIsNull();

    //Esta funcion trae todas las categorias de manufacturado y de insumos que no son para elaborar
    @Query(value = """ 
        SELECT * FROM Categoria
        WHERE ELIMINADO=FALSE AND Tipo_categoria_id = 2
        UNION
        SELECT C.* FROM CATEGORIA  AS C
        LEFT JOIN ARTICULO AS A
        ON A.CATEGORIA_ID = C.ID
        LEFT JOIN ARTICULO_INSUMO AS AI
        ON A.ID = AI.ID
        WHERE AI.ES_PARA_ELABORAR = FALSE AND AI.ELIMINADO = FALSE AND A.ELIMINADO = FALSE AND C.ELIMINADO = FALSE
    """, nativeQuery = true)
    List<Categoria> findCategoriaParaVentas();

    @Query(value=
            """     
        
        SELECT * FROM Categoria 
            WHERE ELIMINADO=FALSE AND Tipo_categoria_id =?1
    """, nativeQuery = true
    )
    List<Categoria> findByTipoCategoria(@Param("idTipoCategoria") Long idTipoCategoria );
}
