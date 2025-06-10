package ElBuenSabor.UTN.Controller;

import ElBuenSabor.UTN.Models.Model.EntityBean;
import ElBuenSabor.UTN.Service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


public abstract class BaseControllerImpl<E extends EntityBean, S extends BaseServiceImpl<E,Long>> implements BaseController<E, Long> {

    protected final S service;

    public BaseControllerImpl(S service) {
        this.service = service;
    }


    @GetMapping("")
    public ResponseEntity<List<E>> getAll()  {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody E entity){
        return ResponseEntity.ok(service.save(entity));
    }
    @PostMapping("/{id}")
    public ResponseEntity<?> update(@RequestParam Long id, @RequestBody E entity){
        if(id > 0) {
            entity.setId(id);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id: " + id + " no valido");
        }
        return ResponseEntity.ok(service.update(entity));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        if(id > 0) {
            return ResponseEntity.ok(service.deleteById(id));
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id: " + id + " no valido");
        }
    }

}
