package ElBuenSabor.UTN.Controller;

import ElBuenSabor.UTN.Models.Model.EntityBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;

public interface BaseController <E extends EntityBean, ID extends Serializable> {

    public ResponseEntity<?> getAll();
    public ResponseEntity<?> getById(@PathVariable ID id);
    public ResponseEntity<?> save(@RequestBody E entity);
    public ResponseEntity<?> update(@RequestParam ID id, @RequestBody E entity);
    public ResponseEntity<?> deleteById(@PathVariable ID id);
}
