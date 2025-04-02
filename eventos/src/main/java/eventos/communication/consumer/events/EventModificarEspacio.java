package eventos.communication.consumer.events;

import eventos.communication.RabbitEvent;

public class EventModificarEspacio extends RabbitEvent {

	private int capacidad;

	public EventModificarEspacio() {
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

}
