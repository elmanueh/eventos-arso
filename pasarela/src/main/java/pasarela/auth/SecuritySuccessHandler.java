package pasarela.auth;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import pasarela.auth.dto.AuthResponseDto;
import pasarela.servicio.IServicioAuth;

@Component
public class SecuritySuccessHandler implements AuthenticationSuccessHandler {

	private final IServicioAuth servicio;

	public SecuritySuccessHandler(IServicioAuth servicio) {
		this.servicio = servicio;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) throws IOException {

		DefaultOAuth2User usuario = (DefaultOAuth2User) authentication.getPrincipal();

		Map<String, Object> claims = fetchUserInfo(usuario);

		if (claims != null) {
			AuthResponseDto authResponse = new AuthResponseDto();
			authResponse.setToken(JwtUtils.generateToken(claims));
			authResponse.setIdUsuario(servicio.obtenerId(usuario.getName()));
			authResponse.setNombreUsuario(usuario.getAttribute("name"));
			authResponse.setRolesUsuario(servicio.obtenerRoles(usuario.getName()));

			ObjectMapper objectMapper = new ObjectMapper();

			response.addCookie(JwtUtils.crearCookie(authResponse.getToken()));
			response.setContentType("application/json");
			objectMapper.writeValue(response.getWriter(), authResponse);
		}
	}

	private Map<String, Object> fetchUserInfo(DefaultOAuth2User usuario) {
		if (!servicio.verificarCredenciales(usuario.getName())) {
			servicio.crearUsuario(usuario.getName(), usuario.getAttribute("name"));
		}

		HashMap<String, Object> claims = new HashMap<>();
		claims.put("sub", usuario.getName());
		claims.put("roles", servicio.obtenerRoles(usuario.getName()));

		return claims;
	}
}