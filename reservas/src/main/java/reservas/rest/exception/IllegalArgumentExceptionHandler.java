package reservas.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class IllegalArgumentExceptionHandler {

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<MessageError> handleNotFoundException(IllegalArgumentException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new MessageError(HttpStatus.BAD_REQUEST, ex.getMessage()));
	}

}
