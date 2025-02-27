package espacios.servicio;

import java.util.HashMap;
import java.util.Map;

public class ServicioAuth implements IServicioAuth {

    private final Map<String, String> usuarios;
    private final Map<String, String> roles;

    public ServicioAuth() {
        usuarios = new HashMap<>();
        usuarios.put("gestor", "gestor123");
        usuarios.put("propietario", "propietario123");
        usuarios.put("usuario", "usuario123");
        usuarios.put("admin", "admin123");

        roles = new HashMap<>();
        roles.put("gestor", "GESTOR_EVENTOS");
        roles.put("propi", "PROPIETARIO_ESPACIOS");
        roles.put("user", "USUARIO");
        roles.put("admin", "GESTOR_EVENTOS, PROPIETARIO_ESPACIOS, USUARIO");
    }

    @Override
    public Boolean verificarCredenciales(String usuario, String contraseña) {
        return usuarios.containsKey(usuario) && usuarios.get(usuario).equals(contraseña);
    }

    @Override
    public String obtenerRoles(String usuario) {
        return roles.get(usuario);
    }
}
