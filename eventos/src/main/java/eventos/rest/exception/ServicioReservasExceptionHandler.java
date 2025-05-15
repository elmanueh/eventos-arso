package eventos.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import eventos.servicio.reservas.exception.ServicioReservasException;

@ControllerAdvice
public class ServicioReservasExceptionHandler {

	@ExceptionHandler(ServicioReservasException.class)
	public ResponseEntity<MessageError> handleNotFoundException(ServicioReservasException ex) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new MessageError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage()));
	}
}
