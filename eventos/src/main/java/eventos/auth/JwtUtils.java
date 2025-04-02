package eventos.auth;

import java.util.Base64;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public class JwtUtils {

    public static Map<String, Object> decodeToken(String token) throws Exception {

        String[] chunks = token.split("\\.");
        if (chunks.length < 2) {
            throw new IllegalArgumentException("Token inválido");
        }

        String payloadJson = new String(Base64.getUrlDecoder().decode(chunks[1]));

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(payloadJson, new TypeReference<Map<String, Object>>() {
        });
    }
}
