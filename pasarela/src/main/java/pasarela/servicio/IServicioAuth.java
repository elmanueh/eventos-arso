package pasarela.servicio;

import java.util.UUID;

public interface IServicioAuth {

    boolean verificarCredenciales(String usuario, String contraseña);

    String obtenerRoles(String usuario);

    UUID obtenerId(String usuario);
}
