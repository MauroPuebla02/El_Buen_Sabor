package ElBuenSabor.UTN.Repository;

import ElBuenSabor.UTN.Models.DTO.CategoriaByManufactoradoDTO;
import ElBuenSabor.UTN.Models.Model.Categoria;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

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

}
