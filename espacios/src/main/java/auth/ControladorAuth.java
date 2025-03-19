package auth;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import espacios.servicio.FactoriaServicios;
import espacios.servicio.auth.IServicioAuth;

@Path("auth")
public class ControladorAuth {

	private IServicioAuth servicio = FactoriaServicios.getServicio(IServicioAuth.class);

	@POST
	@Path("/login")
	public Response login(@FormParam("username") String username, @FormParam("password") String password) {

		Map<String, Object> claims = verificarCredenciales(username, password);
		if (claims != null) {
			String token = JwtUtils.generateToken(claims);
			return Response.ok(token).build();
		} else {
			return Response.status(Response.Status.UNAUTHORIZED).entity("Credenciales inválidas").build();
		}
	}

	private Map<String, Object> verificarCredenciales(String username, String password) {

		if (!servicio.verificarCredenciales(username, password))
			return null;

		HashMap<String, Object> claims = new HashMap<String, Object>();
		claims.put("sub", username);
		claims.put("roles", servicio.obtenerRoles(username));

		return claims;
	}

}
