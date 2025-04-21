package reservas.rest.dto;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Objeto de transferencia de datos (DTO) que representa la respuesta de una entidad de reserva")
public class ReservaResponseDTO {

	@Schema(description = "Identificador único de la reserva", example = "f3b5c8d2-4e1a-4b0c-9f7d-6e1a2b3c4d5e")
	private UUID id;

	@Schema(description = "Identificador único del usuario asociado a la reserva", example = "85d7414c-d677-4890-89b2-482c91aa2597")
	private UUID idUsuario;

	@Schema(description = "Cantidad de plazas reservadas", example = "2")
	private int plazasReservadas;

	@Schema(description = "Estado que indica si la reserva ha sido cancelada", example = "false")
	private boolean cancelada;

	@Schema(description = "Identificador único del evento asociado a la reserva", example = "f3b5c8d2-4e1a-4b0c-9f7d-6e1a2b3c4d5e")
	private UUID evento;

	public ReservaResponseDTO() {
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

	public UUID getEvento() {
		return evento;
	}

	public void setEvento(UUID evento) {
		this.evento = evento;
	}
}
