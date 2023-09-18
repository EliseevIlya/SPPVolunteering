package volunteering.SPP.exceptions;

import jakarta.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@AllArgsConstructor
@ControllerAdvice(annotations = RestController.class)
public class ErrorResponseWrapper {
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity handleDefaultErrors(HttpMessageNotReadableException ex) {
        StatusException statusException = new StatusException(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(statusException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity handleDefaultErrors(ResponseStatusException ex) {
        StatusException statusException = new StatusException(ex.getReason(), ex.getStatusCode().value());
        return new ResponseEntity<>(statusException, ex.getStatusCode());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity handleConstraint(DataIntegrityViolationException ex) {
        String message = NestedExceptionUtils.getMostSpecificCause(ex).getMessage();
        StatusException errorMessage = new StatusException(message, HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity handleConstraint(ConstraintViolationException ex) {
        String message = ex.getConstraintViolations().stream().findFirst().get().getMessageTemplate();
        StatusException errorMessage = new StatusException(message, HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
