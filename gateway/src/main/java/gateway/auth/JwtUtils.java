package gateway.auth;

import java.time.Instant;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.Cookie;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtils {

	private static final String SECRETO = "secreto";
	private static final long TIEMPO = 3600; // 1 hora

	// curl -i -X POST -H "Content-Type: application/x-www-form-urlencoded" -d
	// "username=juan&password=clave" http://localhost:8080/auth/login

	public static String generateToken(Map<String, Object> claims) {

		Date caducidad = Date.from(Instant.now().plusSeconds(TIEMPO));

		String token = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256, SECRETO)
				.setExpiration(caducidad).compact();

		return token;
	}

	public static Claims validateToken(String token) {

		Claims claims = Jwts.parser()
				.setSigningKey(SECRETO)
				.parseClaimsJws(token)
				.getBody();

		return claims;
	}
	
	public static Cookie crearCookie(String token) {
    	Cookie cookie = new Cookie("jwt", token);
    	cookie.setMaxAge((int) TIEMPO); 
    	// cookie.setSecure(true);
    	cookie.setHttpOnly(true);
    	cookie.setPath("/");

    	return cookie;
		
	}

}
