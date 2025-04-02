package eventos.communication.consumer.events;

import eventos.communication.RabbitEvent;

public class EventCrearEspacio extends RabbitEvent {

	private boolean cancelado;
	private int capacidad;

	public EventCrearEspacio() {
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
}
