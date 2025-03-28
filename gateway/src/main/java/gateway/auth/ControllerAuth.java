package gateway.auth;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gateway.auth.dto.AuthResponse;
import gateway.servicio.auth.IServicioAuth;

@RestController
@RequestMapping("/auth")
public class ControllerAuth {
	
	private IServicioAuth servicio;
	
	@Autowired
	public ControllerAuth(IServicioAuth servicio) {
		this.servicio = servicio;
	}

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestParam String username, @RequestParam String password, HttpServletResponse response) {

        Map<String, Object> claims = verificarCredenciales(username, password);
        System.out.println("Claims: " + claims);
        if (claims != null) {
            // Crear la respuesta con el token, userId, username y roles
            AuthResponse authResponse = new AuthResponse();
            authResponse.setToken(JwtUtils.generateToken(claims));
            authResponse.setUserId(servicio.obtenerId(username));
            authResponse.setUsername(username);
            authResponse.setRoles(servicio.obtenerRoles(username));

            response.addCookie(JwtUtils.crearCookie(authResponse.getToken()));
            return ResponseEntity.ok(authResponse);
        } else {
        	// Enviar "Credenciales inválidas"
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
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
