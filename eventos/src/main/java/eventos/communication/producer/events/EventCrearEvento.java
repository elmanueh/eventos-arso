package eventos.communication.producer.events;

import java.time.LocalDateTime;
import java.util.UUID;

import eventos.communication.RabbitEvent;

public class EventCrearEvento extends RabbitEvent {

	private String nombre;
	private String descripcion;
	private String organizador;
	private String categoria;
	private int capacidad;
	private boolean cancelado;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	private UUID espacioFisico;

	public EventCrearEvento() {
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

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public boolean isCancelado() {
		return cancelado;
	}

	public void setCancelado(boolean cancelado) {
		this.cancelado = cancelado;
	}

	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDateTime getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDateTime fechaFin) {
		this.fechaFin = fechaFin;
	}

	public UUID getEspacioFisico() {
		return espacioFisico;
	}

	public void setEspacioFisico(UUID espacioFisico) {
		this.espacioFisico = espacioFisico;
	}
}
