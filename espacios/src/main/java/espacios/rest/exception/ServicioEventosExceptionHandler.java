package espacios.rest.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import espacios.servicio.eventos.exception.ServicioEventosException;

@Provider
public class ServicioEventosExceptionHandler implements ExceptionMapper<ServicioEventosException> {

	@Override
	public Response toResponse(ServicioEventosException arg0) {
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
				.entity(new MessageError(Response.Status.INTERNAL_SERVER_ERROR, arg0.getMessage())).build();
	}
}
