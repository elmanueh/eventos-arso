package espacios.rest.dto;

import java.util.UUID;

public class ResumenEspacioFisicoResponseDTO {
    private UUID id;
    private String nombre;
    private String propietario;
    private String estado;

    public ResumenEspacioFisicoResponseDTO() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
