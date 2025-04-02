package pasarela.auth;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
            @NonNull FilterChain chain) throws IOException, ServletException {

        // Evitar filtrado en la ruta de login y logout
    	if (request.getServletPath().equals("/auth/login") || request.getServletPath().equals("/auth/logout")) {
    	    chain.doFilter(request, response);
    	    return;
    	}

        String token = null;

        String authorization = request.getHeader("Authorization");

		if (authorization != null && authorization.startsWith("Bearer ")) {
			token = authorization.substring("Bearer ".length()).trim();
		} else if (request.getCookies() != null) {
            token = Arrays.stream(request.getCookies())
                    .filter(cookie -> cookie.getName().equals("jwt"))
                    .map(Cookie::getValue)
                    .findFirst()
                    .orElse(null);
        }

        if (token == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Se requiere autenticación.");
            return;
        }

        try {
            Claims claims = JwtUtils.validateToken(token);

            String username = claims.getSubject();
            if (username == null) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "El token JWT no es correcto");
                return;
            }

        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "El token JWT no es correcto");
            return;
        }

        chain.doFilter(request, response);

    }
}
