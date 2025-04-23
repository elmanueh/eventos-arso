package pasarela.auth;

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

import pasarela.auth.dto.AuthResponseDto;
import pasarela.servicio.IServicioAuth;

@RestController
@RequestMapping("/auth")
public class ControladorAuth {

    private final IServicioAuth servicio;

    @Autowired
    public ControladorAuth(IServicioAuth servicio) {
        this.servicio = servicio;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestParam String usuario, @RequestParam String contraseña,
            HttpServletResponse respuesta) {

        Map<String, Object> claims = verificarCredenciales(usuario, contraseña);
        if (claims == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        // Creamos la respuesta con el token JWT
        AuthResponseDto authResponse = new AuthResponseDto();
        authResponse.setToken(JwtUtils.generateToken(claims));
        authResponse.setIdUsuario(servicio.obtenerId(usuario));
        authResponse.setNombreUsuario(usuario);
        authResponse.setRolesUsuario(servicio.obtenerRoles(usuario));

        respuesta.addCookie(JwtUtils.crearCookie(authResponse.getToken()));

        return ResponseEntity.ok(authResponse);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletResponse response) {
        response.addCookie(JwtUtils.eliminarCookie());

        return ResponseEntity.ok().build();
    }

    private Map<String, Object> verificarCredenciales(String username, String password) {

        if (!servicio.verificarCredenciales(username, password))
            return null;

        HashMap<String, Object> claims = new HashMap<String, Object>();
        claims.put("sub", servicio.obtenerId(username));
        claims.put("username", username);
        claims.put("roles", servicio.obtenerRoles(username));

        return claims;
    }
}
