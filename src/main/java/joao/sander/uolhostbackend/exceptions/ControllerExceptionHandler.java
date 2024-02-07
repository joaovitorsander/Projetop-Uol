package joao.sander.uolhostbackend.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler
    public ResponseEntity threatNoSuchElementException(NoSuchElementException exception) {
        ExceptionDTO dto = new ExceptionDTO("Essa lista não possui mais usuários disponíveis", "400");
        return ResponseEntity.badRequest().body(dto);
    }
}
