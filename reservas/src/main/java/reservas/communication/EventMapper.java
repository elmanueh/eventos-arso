package reservas.communication;

import reservas.communication.producer.events.EventCrearReserva;
import reservas.modelo.Reserva;

public class EventMapper {

	private EventMapper() {
	}

	public static RabbitEvent Domain2EventCrearReserva(Reserva entidad) {
		EventCrearReserva event = new EventCrearReserva();
		event.setIdUsuario(entidad.getIdUsuario());
		event.setPlazasReservadas(entidad.getPlazasReservadas());
		event.setCancelada(entidad.isCancelada());
		event.setIdEvento(entidad.getEvento().getId());

		return event;
	}
}
