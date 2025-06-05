package ElBuenSabor.UTN.Service;


import ElBuenSabor.UTN.Models.Model.EntityBean;
import ElBuenSabor.UTN.Repository.BaseRepository;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.List;

public abstract class BaseServiceImpl<E extends EntityBean, ID extends Serializable> implements iBaseService<E, ID> {
    protected BaseRepository<E, ID> repository;

    public BaseServiceImpl(BaseRepository<E, ID> repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public E findById(ID id){
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public E save(E entity){
        return repository.save(entity);
    }

    @Override
    @Transactional
    public E update(E entity){
        return repository.save(entity);
    }

    @Override
    @Transactional
    public boolean deleteById(ID id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
