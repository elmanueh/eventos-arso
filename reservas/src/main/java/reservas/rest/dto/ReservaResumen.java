package reservas.rest.dto;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Resumen de la reserva")
public class ReservaResumen {

	@Schema(description = "Identificador de la reserva", example = "f47a671a-c956-4f95-95be-19fcd4b23eb1")
	private UUID id;

	@Schema(description = "Identificador del usuario", example = "137dfb58-195c-448a-8d10-3e02fdb45e3f")
	private UUID idUsuario;

	@Schema(description = "Número de plazas reservadas", example = "2")
	private int plazasReservadas;

	@Schema(description = "Indica si la reserva ha sido cancelada", example = "false")
	private boolean cancelada;

	@Schema(description = "Indica si el evento está activo", example = "true")
	private boolean evento;

	public ReservaResumen() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(UUID idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getPlazasReservadas() {
		return plazasReservadas;
	}

	public void setPlazasReservadas(int plazasReservadas) {
		this.plazasReservadas = plazasReservadas;
	}

	public boolean isCancelada() {
		return cancelada;
	}

	public void setCancelada(boolean cancelada) {
		this.cancelada = cancelada;
	}

	public boolean isEvento() {
		return evento;
	}

	public void setEvento(boolean evento) {
		this.evento = evento;
	}

}
