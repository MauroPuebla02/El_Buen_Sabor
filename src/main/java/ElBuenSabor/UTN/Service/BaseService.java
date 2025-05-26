package ElBuenSabor.UTN.Service;

import ElBuenSabor.UTN.Models.Model.EntityBean;

import java.io.Serializable;
import java.util.List;

public interface BaseService <E extends EntityBean, ID extends Serializable> {
    public List<E> findAll() throws Exception;
    public E findById(ID id)throws Exception;
    public E save(E entity)throws Exception;
    public E update(E entity)throws Exception;
    public boolean deleteById(ID id)throws Exception;

}
