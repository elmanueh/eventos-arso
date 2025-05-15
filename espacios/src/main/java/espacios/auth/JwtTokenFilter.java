package espacios.auth;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.Priority;
import javax.annotation.security.RolesAllowed;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class JwtTokenFilter implements ContainerRequestFilter {

	@Context
	private ResourceInfo resourceInfo;

	@Context
	private HttpServletRequest servletRequest;

	@Override
	public void filter(ContainerRequestContext requestContext) {
		String authorization = requestContext.getHeaderString("Authorization");
		String token = null;

		// Obtener el token del encabezado Authorization o de las cookies
		if (authorization != null && authorization.startsWith("Bearer ")) {
			token = authorization.substring("Bearer ".length()).trim();
		} else if (servletRequest.getCookies() != null) {
			for (Cookie cookie : servletRequest.getCookies()) {
				if (cookie.getName().equals("jwt")) {
					token = cookie.getValue();
				}
			}
		}

		if (token == null) {
			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
					.entity("No se adjunta el token correctamente").build());
			return;
		}

		try {
			Map<String, Object> claims = JwtUtils.decodeToken(token);

			if (claims == null) {
				requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
						.entity("Token inválido o expirado").build());
				return;
			}

			String roles = (String) claims.get("roles");

			// Convertir los roles a una lista de GrantedAuthority
			Set<String> authorities = new HashSet<>();
			authorities.addAll(Arrays.asList(roles.split(",")));

			servletRequest.setAttribute("claims", claims);

			// Verificar roles si es necesario
			if (resourceInfo.getResourceMethod().isAnnotationPresent(RolesAllowed.class)) {
				String[] allowedRoles = resourceInfo.getResourceMethod().getAnnotation(RolesAllowed.class).value();

				if (authorities.stream().noneMatch(userRole -> Arrays.asList(allowedRoles).contains(userRole))) {
					requestContext.abortWith(
							Response.status(Response.Status.FORBIDDEN).entity("No tiene rol de acceso").build());
				}
			}

		} catch (Exception e) {
			requestContext.abortWith(
					Response.status(Response.Status.UNAUTHORIZED).entity("Token inválido: " + e.getMessage()).build());
		}

	}
}
