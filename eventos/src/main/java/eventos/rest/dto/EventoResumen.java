package eventos.rest.dto;

import java.util.UUID;

public class EventoResumen {

	private UUID id;
	private String nombre;
	private String descripcion;
	private boolean cancelado;
	private int numPlazas;
	private String fechaInicio;

	private String fechaFin;

	private int numPlazasDisponibles;

	public EventoResumen() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

	public boolean isCancelado() {
		return cancelado;
	}

	public void setCancelado(boolean cancelado) {
		this.cancelado = cancelado;
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

	public int getNumPlazasDisponibles() {
		return numPlazasDisponibles;
	}

	public void setNumPlazasDisponibles(int numPlazasDisponibles) {
		this.numPlazasDisponibles = numPlazasDisponibles;
	}

}
