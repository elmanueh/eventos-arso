package pasarela.servicio;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import pasarela.auth.dominio.Usuario;

@Service
public class ServicioAuth implements IServicioAuth {

    private final Map<String, Usuario> usuarios;

    public ServicioAuth() {
        usuarios = new HashMap<>();
        usuarios.put("gestor", new Usuario(UUID.randomUUID(), "gestor", "gestor123", "GESTOR_EVENTOS"));
        usuarios.put("propietario",
                new Usuario(UUID.randomUUID(), "propietario", "propietario123", "PROPIETARIO_ESPACIOS"));
        usuarios.put("usuario", new Usuario(UUID.randomUUID(), "usuario", "usuario123", "USUARIO"));
        usuarios.put("admin",
                new Usuario(UUID.randomUUID(), "admin", "admin123", "GESTOR_EVENTOS,PROPIETARIO_ESPACIOS,USUARIO"));
    }

    @Override
    public boolean verificarCredenciales(String usuario, String contraseña) {
        if (!usuarios.containsKey(usuario))
            return false;

        Usuario user = usuarios.get(usuario);
        return user.getContraseña().equals(contraseña);
    }

    @Override
    public String obtenerRoles(String usuario) {
        return usuarios.get(usuario).getRoles();
    }

    @Override
    public UUID obtenerId(String usuario) {
        return usuarios.get(usuario).getId();
    }

}
