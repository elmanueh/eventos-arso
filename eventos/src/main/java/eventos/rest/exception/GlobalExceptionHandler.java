package eventos.rest.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import eventos.repositorio.EntidadNoEncontrada;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EntidadNoEncontrada.class)
	public ResponseEntity<MessageError> handleNotFoundException(EntidadNoEncontrada ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new MessageError(HttpStatus.NOT_FOUND, ex.getMessage()));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MessageError> handleValidationException(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach(error -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});

		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new MessageError(HttpStatus.BAD_REQUEST, "Fallo al validar los parámetros.", errors));
	}

}
