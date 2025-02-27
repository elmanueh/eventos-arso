package espacios.servicio;

import java.util.HashMap;
import java.util.Map;

public class ServicioAuth implements IServicioAuth {

    private final Map<String, String> usuarios;

    public ServicioAuth() {
        usuarios = new HashMap<>();
        usuarios.put("admin", "admin123");
        usuarios.put("user1", "user1");
        usuarios.put("user2", "user2");
    }

    @Override
    public Boolean verificarCredenciales(String usuario, String contraseña) {
        return usuarios.containsKey(usuario) && usuarios.get(usuario).equals(contraseña);
    }
}
