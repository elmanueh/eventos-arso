package eventos.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import eventos.repositorio.EntidadNoEncontrada;

@ControllerAdvice
public class EntidadNoEncontradaExceptionHandler {

	@ExceptionHandler(EntidadNoEncontrada.class)
	public ResponseEntity<MessageError> handleNotFoundException(EntidadNoEncontrada ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new MessageError(HttpStatus.NOT_FOUND, ex.getMessage()));
	}

}
