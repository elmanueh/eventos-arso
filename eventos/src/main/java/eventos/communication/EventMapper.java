package eventos.communication;

import java.util.UUID;

import eventos.communication.producer.events.EventCancelarEvento;
import eventos.communication.producer.events.EventCrearEvento;
import eventos.communication.producer.events.EventModificarEvento;
import eventos.modelo.Evento;

public class EventMapper {

	private EventMapper() {
	}

	public static EventCrearEvento Domain2EventCrearEvento(Evento evento) {
		EventCrearEvento event = new EventCrearEvento();
		event.setNombre(evento.getNombre());
		event.setDescripcion(evento.getDescripcion());
		event.setOrganizador(evento.getOrganizador());
		event.setCategoria(evento.getCategoria().name());
		event.setCapacidad(evento.getNumPlazas());
		event.setCancelado(event.isCancelado());
		event.setFechaHora(evento.getOcupacion().getFechaFin());
		event.setFechaFin(evento.getOcupacion().getFechaFin());
		event.setEspacioFisico(evento.getOcupacion().getEspacioFisico().getId());

		return event;
	}

	public static EventModificarEvento Domain2EventModificarEvento(Evento evento) {
		EventModificarEvento event = new EventModificarEvento();
		event.setDescripcion(evento.getDescripcion());
		event.setFechaInicio(evento.getOcupacion().getFechaInicio());
		event.setFechaFin(evento.getOcupacion().getFechaFin());
		event.setEspacioFisico(evento.getOcupacion().getEspacioFisico().getId());
		event.setNumPlazas(evento.getNumPlazas());

		return event;
	}

	public static EventCancelarEvento Domain2EventCancelarEvento(UUID idEntidad) {
		EventCancelarEvento event = new EventCancelarEvento();

		return event;
	}
}
