package espacios.communication.producer.events;

import espacios.communication.RabbitEvent;

public class EventModificarEspacio extends RabbitEvent {

	private String nombre;
	private int capacidad;

	public EventModificarEspacio() {
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
