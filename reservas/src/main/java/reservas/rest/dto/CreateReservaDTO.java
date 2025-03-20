package reservas.rest.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Objeto de transferencia para la creación de una reserva. Contiene la información necesaria para realizar una reserva en el sistema.", requiredProperties = {
		"idEvento", "idUsuario", "numPlazas" })
public class CreateReservaDTO {

	@Schema(description = "Identificador único del evento al que se desea asistir.", example = "12345", required = true)
	@NotBlank(message = "El id del evento no puede ser nulo o vacío")
	private String idEvento;

	@Schema(description = "Identificador único del usuario que realiza la reserva.", example = "67890", required = true)
	@NotBlank(message = "El id del usuario no puede ser nulo o vacío")
	private String idUsuario;

	@Schema(description = "Cantidad de plazas que se desean reservar. Debe ser un número mayor a 0.", example = "2", required = true)
	@NotNull(message = "El número de plazas no puede ser nulo o vacío")
	@Min(value = 1, message = "El número de plazas debe ser mayor que 0")
	private int numPlazas;

	public CreateReservaDTO() {
	}

	public String getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(String idEvento) {
		this.idEvento = idEvento;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getNumPlazas() {
		return numPlazas;
	}

	public void setNumPlazas(int numPlazas) {
		this.numPlazas = numPlazas;
	}

}
