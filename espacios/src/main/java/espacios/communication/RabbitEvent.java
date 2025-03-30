package espacios.communication;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class RabbitEvent {

	private LocalDateTime fechaHora;
	private String tipoEvento;
	private UUID idEntidad;

	public RabbitEvent() {
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public UUID getIdEntidad() {
		return idEntidad;
	}

	public void setIdEntidad(UUID idEntidad) {
		this.idEntidad = idEntidad;
	}

	public String getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

}
