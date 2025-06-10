package ElBuenSabor.UTN.Service;

import ElBuenSabor.UTN.Models.Model.EntityBean;

import java.io.Serializable;
import java.util.List;

public interface iBaseService<E extends EntityBean, ID extends Serializable> {
    public List<E> findAll() ;
    public E findById(ID id);
    public E save(E entity);
    public E update(E entity);
    public boolean deleteById(ID id);
}
