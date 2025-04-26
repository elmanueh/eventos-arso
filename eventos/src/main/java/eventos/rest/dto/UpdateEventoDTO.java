package eventos.rest.dto;

import java.util.UUID;

import javax.validation.constraints.Min;
import org.springframework.format.annotation.DateTimeFormat;

public class UpdateEventoDTO {

	private String descripcion;

	@Min(value = 0, message = "El número de plazas del evento debe ser mayor que 0")
	private int numPlazas;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private String fechaInicio;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private String fechaFin;

	private UUID espacioFisico;

	public UpdateEventoDTO() {
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getNumPlazas() {
		return numPlazas;
	}

	public void setNumPlazas(int numPlazas) {
		this.numPlazas = numPlazas;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public UUID getEspacioFisico() {
		return espacioFisico;
	}

	public void setEspacioFisico(UUID espacioFisico) {
		this.espacioFisico = espacioFisico;
	}

}
