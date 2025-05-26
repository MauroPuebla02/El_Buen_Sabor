package ElBuenSabor.UTN.Advice;

import ElBuenSabor.UTN.Models.DTO.ErrorDTO;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Captura ResponseStatusException (404, 500, etc).
     */
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorDTO> handleResponseStatus(ResponseStatusException ex) {
        ErrorDTO error = new ErrorDTO(
                ex.getStatusCode().value(),
                ex.getReason()
        );
        return ResponseEntity
                .status(ex.getStatusCode())
                .contentType(MediaType.APPLICATION_JSON)
                .body(error);
    }

    /**
     * Captura cualquier excepción no prevista.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleAll(Exception ex) {
        ErrorDTO error = new ErrorDTO(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Ocurrió un error inesperado"
        );
        // opcional: loguear ex.getMessage() o stacktrace
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(error);
    }
}