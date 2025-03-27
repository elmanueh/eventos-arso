package eventos.communication.consumer.events;

import eventos.communication.RabbitEvent;

public class EventCambiarEstadoEspacio extends RabbitEvent {

	private boolean cancelado;

	public EventCambiarEstadoEspacio() {
	}

	public boolean isCancelado() {
		return cancelado;
	}

	public void setCancelado(boolean cancelado) {
		this.cancelado = cancelado;
	}
}
