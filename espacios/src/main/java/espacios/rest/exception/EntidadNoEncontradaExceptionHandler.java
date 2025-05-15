package espacios.rest.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import espacios.repositorio.exception.EntidadNoEncontrada;

@Provider
public class EntidadNoEncontradaExceptionHandler implements ExceptionMapper<EntidadNoEncontrada> {

	@Override
	public Response toResponse(EntidadNoEncontrada arg0) {
		return Response.status(Response.Status.NOT_FOUND)
				.entity(new MessageError(Response.Status.NOT_FOUND, arg0.getMessage())).build();
	}
}
