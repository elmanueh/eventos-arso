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
			String token = JwtUtils.generateToken(claims);
			
	        response.addCookie(JwtUtils.crearCookie(token));
	        
	        response.getWriter().println(token);
		}
	}

	private Map<String, Object> fetchUserInfo(DefaultOAuth2User usuario) {
	    if (!servicio.verificarCredenciales(usuario.getName())) {
	    	servicio.crearUsuario(usuario.getName());
	    }

	    HashMap<String, Object> claims = new HashMap<>();
	    claims.put("sub", usuario.getName());
	    
	    claims.put("roles", servicio.obtenerRoles(usuario.getName()));

	    return claims;
	}
}