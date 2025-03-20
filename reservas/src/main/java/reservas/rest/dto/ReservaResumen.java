package reservas.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Resumen de la reserva")
public class ReservaResumen {

	@Schema(description = "Identificador de la reserva", example = "abc123")
	private String id;

	@Schema(description = "Identificador del usuario", example = "67890")
	private String idUsuario;

	@Schema(description = "Número de plazas reservadas", example = "2")
	private int plazasReservadas;

	@Schema(description = "Indica si la reserva ha sido cancelada", example = "false")
	private boolean cancelada;

	@Schema(description = "Indica si el evento está activo", example = "true")
	private boolean evento;

	public ReservaResumen() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
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
