package espacios.servicio.auth;

public interface IServicioAuth {
    Boolean verificarCredenciales(String usuario, String contrasena);

    String obtenerRoles(String usuario);
}
