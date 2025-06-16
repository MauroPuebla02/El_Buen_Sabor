package ElBuenSabor.UTN.Repository;

import ElBuenSabor.UTN.Models.Model.EntityBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository<E extends EntityBean, ID extends Serializable> extends JpaRepository<E, ID> {


}
