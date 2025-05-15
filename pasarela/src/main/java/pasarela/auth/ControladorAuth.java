package pasarela.auth;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/user")
    public ResponseEntity<AuthResponseDto> obtenerUsuario(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null)
            return ResponseEntity.badRequest().build();

        return Arrays.stream(cookies)
                .filter(cookie -> "jwt".equals(cookie.getName()))
                .map(Cookie::getValue)
                .map(JwtUtils::decodeToken)
                .map(claims -> {
                    UUID idUsuario = UUID.fromString((String) claims.get("sub"));
                    String nombreUsuario = (String) claims.get("username");
                    String rolesUsuario = (String) claims.get("roles");

                    AuthResponseDto authResponse = new AuthResponseDto();
                    authResponse.setIdUsuario(idUsuario);
                    authResponse.setNombreUsuario(nombreUsuario);
                    authResponse.setRolesUsuario(rolesUsuario);
                    return ResponseEntity.ok(authResponse);
                })
                .findFirst()
                .orElse(ResponseEntity.badRequest().build());
    }

    private Map<String, Object> verificarCredenciales(String username, String password) {

        if (!servicio.verificarCredenciales(username, password))
            return null;

        HashMap<String, Object> claims = new HashMap<>();
        claims.put("sub", servicio.obtenerId(username));
        claims.put("username", username);
        claims.put("roles", servicio.obtenerRoles(username));

        return claims;
    }
}
