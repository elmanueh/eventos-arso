package espacios.communication.producer.events;

import espacios.communication.RabbitEvent;

public class EventModificarEstadoEspacio extends RabbitEvent {

	private boolean cancelado;

	public EventModificarEstadoEspacio() {
	}

	public boolean isCancelado() {
		return cancelado;
	}

	public void setCancelado(boolean cancelado) {
		this.cancelado = cancelado;
	}
}
