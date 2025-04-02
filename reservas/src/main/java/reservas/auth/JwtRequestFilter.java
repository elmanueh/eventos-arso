package reservas.auth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response, @NonNull FilterChain chain) throws IOException, ServletException {

        String token = null;
        String authorization = request.getHeader("Authorization");

		if (authorization != null && authorization.startsWith("Bearer ")) {
			token = authorization.substring("Bearer ".length()).trim();
		} else if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals("jwt")) {
                    token = cookie.getValue();
                }
            }
        }
        
        //TODO: esto creo que es innecesario
        if (token == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No se adjunta el token correctamente.");
            return;
        }

        if (token != null) {
            Map<String, Object> claims = JwtUtils.decodeToken(token);

            if (claims != null) {
                String username = (String) claims.get("sub");
                String roles = (String) claims.get("roles");

                // Convertir los roles a una lista de GrantedAuthority
                List<GrantedAuthority> authorities = new ArrayList<>();
                for (String rol : roles.split(",")) {
                    authorities.add(new SimpleGrantedAuthority(rol.trim()));
                }

                // Crear el objeto de autenticación
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username, null,
                        authorities);

                // Guardar en el contexto de seguridad
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }

        chain.doFilter(request, response);
    }
}
