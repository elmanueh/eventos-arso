package eventos.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class IllegalStateExceptionHandler {

	@ExceptionHandler(IllegalStateException.class)
	public ResponseEntity<MessageError> handleNotFoundException(IllegalStateException ex) {
		return ResponseEntity.status(HttpStatus.CONFLICT)
				.body(new MessageError(HttpStatus.CONFLICT, ex.getMessage()));
	}

}
