package espacios.auth;

import java.util.Base64;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JwtUtils {

	public static Map<String, Object> decodeToken(String token) {
        try {
            String[] chunks = token.split("\\.");
            if (chunks.length < 2) {
                throw new IllegalArgumentException("Token inválido");
            }

            String payloadJson = new String(Base64.getUrlDecoder().decode(chunks[1]));

            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(payloadJson, new TypeReference<Map<String, Object>>() {});

        } catch (Exception e) {
            System.out.println("Error al decodificar el token: " + e.getMessage());
            return null;
        }
    }

}
