package reservas.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Objeto de transferencia de datos (DTO) que representa la respuesta de una entidad de reserva")
public class ReservaResponseDTO {

	@Schema(description = "Identificador único del usuario asociado a la reserva", example = "67890")
	private String idUsuario;

	@Schema(description = "Cantidad de plazas reservadas", example = "2")
	private int plazasReservadas;

	@Schema(description = "Estado que indica si la reserva ha sido cancelada", example = "false")
	private boolean cancelada;

	public ReservaResponseDTO() {
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
}
