package pasarela.auth;

import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.Cookie;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtils {

	private static final String SECRETO = "secreto";
	private static final long TIEMPO = 60 * 60 * 24; // 1 dia

	public static String generateToken(Map<String, Object> claims) {
		Date caducidad = Date.from(Instant.now().plusSeconds(TIEMPO));
		return Jwts.builder()
				.setClaims(claims)
				.signWith(SignatureAlgorithm.HS256, SECRETO)
				.setExpiration(caducidad)
				.compact();
	}

	public static Claims validateToken(String token) {
		return Jwts.parser()
				.setSigningKey(SECRETO)
				.parseClaimsJws(token)
				.getBody();
	}

	public static Map<String, Object> decodeToken(String token) {

		String[] chunks = token.split("\\.");

		String payloadJson = new String(Base64.getUrlDecoder().decode(chunks[1]));

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.readValue(payloadJson, new TypeReference<Map<String, Object>>() {
			});
		} catch (JsonProcessingException e) {
			throw new RuntimeException("Error decoding token", e);
		}
	}

	public static Cookie crearCookie(String token) {
		Cookie cookie = new Cookie("jwt", token);
		cookie.setMaxAge((int) TIEMPO);
		cookie.setHttpOnly(true);
		cookie.setPath("/");

		return cookie;
	}

	public static Cookie eliminarCookie() {
		Cookie cookie = new Cookie("jwt", null);
		cookie.setMaxAge(0);
		cookie.setHttpOnly(true);
		cookie.setPath("/");

		return cookie;
	}

}
