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
        usuarios.put("gestor", new Usuario(UUID.fromString("f47ac10b-58cc-4372-a567-0e02b2c3d479"), "gestor", "gestor123", "GESTOR_EVENTOS"));
        usuarios.put("propietario",
                new Usuario(UUID.fromString("3fa85f64-5717-4562-b3fc-2c963f66afa6"), "propietario", "propietario123", "PROPIETARIO_ESPACIOS"));
        usuarios.put("usuario", new Usuario(UUID.fromString("6b1d3d79-a0e5-41c9-bb5e-9b90e9b0c5e1"), "usuario", "usuario123", "USUARIO"));
        usuarios.put("usuario2", new Usuario(UUID.fromString("5f3d9d2a-63cc-4d3a-8c45-d56d7dbad2e3"), "usuario2", "usuario123", "USUARIO"));
        usuarios.put("admin",
                new Usuario(UUID.fromString("d9428888-122b-4cbb-bcb9-33a3ee6b9e9b"), "admin", "admin123", "GESTOR_EVENTOS,PROPIETARIO_ESPACIOS,USUARIO"));
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
