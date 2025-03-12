package eventos.rest.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

public class CreateEventoDTO {
	@NotBlank(message = "El nombre del evento no puede ser nulo o vacío")
	private String nombre;

	@NotBlank(message = "La descripción del evento no puede ser nulo o vacío")
	private String descripcion;

	@NotBlank(message = "El organizador del evento no puede ser nulo o vacío")
	private String organizador;

	@NotNull(message = "La categoría del evento no puede ser nula")
	@Pattern(regexp = "ACADEMICOS|CULTURALES|ENTRETENIMIENTO|DEPORTES|OTROS", message = "La categoría del evento no es válida")
	private String categoria;

	@NotNull(message = "El número de plazas del evento no puede ser nulo")
	@Min(value = 1, message = "El número de plazas del evento debe ser mayor que 0")
	private int numPlazas;

	@NotNull(message = "La fecha de inicio del evento no puede ser nula")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private String fechaInicio;

	@NotNull(message = "La fecha de fin del evento no puede ser nula")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private String fechaFin;

	@NotBlank(message = "El id del espacio físico del evento no puede ser nulo o vacío")
	private String espacioFisico;

	public CreateEventoDTO() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getOrganizador() {
		return organizador;
	}

	public void setOrganizador(String organizador) {
		this.organizador = organizador;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
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

	public String getEspacioFisico() {
		return espacioFisico;
	}

	public void setEspacioFisico(String espacioFisico) {
		this.espacioFisico = espacioFisico;
	}

}
