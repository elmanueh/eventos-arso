package gateway.servicio.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class ServicioAuth implements IServicioAuth {

    private final Map<String, String> usuarios;
    private final Map<String, String> roles;
    private final Map<String, String> ids;

    public ServicioAuth() {
        usuarios = new HashMap<>();
        usuarios.put("gestor", "gestor123");
        usuarios.put("propietario", "propietario123");
        usuarios.put("usuario", "usuario123");
        usuarios.put("admin", "admin123");

        roles = new HashMap<>();
        roles.put("gestor", "GESTOR_EVENTOS");
        roles.put("propietario", "PROPIETARIO_ESPACIOS");
        roles.put("usuario", "USUARIO");
        roles.put("admin", "GESTOR_EVENTOS,PROPIETARIO_ESPACIOS,USUARIO");
        
        ids = new HashMap<>();
        ids.put("gestor", "1");
        ids.put("propietario", "2");
        ids.put("usuario", "3");
        ids.put("admin", "4");
    }

    @Override
    public Boolean verificarCredenciales(String usuario, String contraseña) {
        return usuarios.containsKey(usuario) && usuarios.get(usuario).equals(contraseña);
    }

    @Override
    public String obtenerRoles(String usuario) {
        return roles.get(usuario);
    }
    
    @Override
    public String obtenerId(String usuario) {
        return ids.get(usuario);
    }
}
