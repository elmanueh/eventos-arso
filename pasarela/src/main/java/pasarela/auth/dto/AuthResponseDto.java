package pasarela.auth.dto;

import java.util.UUID;

public class AuthResponseDto {
    private String token;
    private UUID idUsuario;
    private String nombreUsuario;
    private String rolesUsuario;

    public AuthResponseDto() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UUID getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UUID idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getRolesUsuario() {
        return rolesUsuario;
    }

    public void setRolesUsuario(String rolesUsuario) {
        this.rolesUsuario = rolesUsuario;
    }

}
