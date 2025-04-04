package espacios.rest.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import espacios.servicio.eventos.exception.RetrofitException;

@Provider
public class RetrofitExceptionHandler implements ExceptionMapper<RetrofitException> {

	@Override
	public Response toResponse(RetrofitException arg0) {
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new MessageError(Response.Status.INTERNAL_SERVER_ERROR, arg0.getMessage())).build();
	}
}
