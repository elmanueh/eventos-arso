package espacios.rest.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class IllegalStateExceptionHandler implements ExceptionMapper<IllegalStateException> {

	@Override
	public Response toResponse(IllegalStateException arg0) {
		return Response.status(Response.Status.CONFLICT).entity(new MessageError(Response.Status.CONFLICT, arg0.getMessage())).build();
	}
}