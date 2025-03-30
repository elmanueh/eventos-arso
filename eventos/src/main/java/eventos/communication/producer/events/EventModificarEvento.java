package eventos.communication.producer.events;

import java.time.LocalDateTime;
import java.util.UUID;

import eventos.communication.RabbitEvent;

public class EventModificarEvento extends RabbitEvent {

	private String descripcion;
	private int numPlazas;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	private UUID espacioFisico;

	public EventModificarEvento() {
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
