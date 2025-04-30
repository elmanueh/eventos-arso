package eventos.rest.dto;

import java.util.UUID;

public class EventoResponseDTO {
	private UUID idEvento;
	private String nombre;
	private String descripcion;
	private String organizador;
	private int numPlazas;
	private boolean cancelado;
	private String categoria;
	private String fechaInicio;
	private String fechaFin;
	private UUID espacioFisico;

	private int numPlazasDisponibles;

	public EventoResponseDTO() {
	}

	public UUID getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(UUID idEvento) {
		this.idEvento = idEvento;
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

	public int getNumPlazas() {
		return numPlazas;
	}

	public void setNumPlazas(int numPlazas) {
		this.numPlazas = numPlazas;
	}

	public boolean isCancelado() {
		return cancelado;
	}

	public void setCancelado(boolean cancelado) {
		this.cancelado = cancelado;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
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

	public void setNumPlazasDisponibles(int numPlazasDisponibles) {
		this.numPlazasDisponibles = numPlazasDisponibles;
	}

	public int getNumPlazasDisponibles() {
		return numPlazasDisponibles;
	}

}
