package reservas.rest.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateReservaDTO {

	@NotBlank(message = "El id del evento no puede ser nulo o vacío")
	private String idEvento;

	@NotBlank(message = "El id del usuario no puede ser nulo o vacío")
	private String idUsuario;

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
