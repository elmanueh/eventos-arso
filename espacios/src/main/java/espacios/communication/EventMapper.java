package espacios.communication;

import espacios.communication.producer.events.EventCrearEspacio;
import espacios.communication.producer.events.EventModificarEspacio;
import espacios.communication.producer.events.EventModificarEstadoEspacio;
import espacios.modelo.EspacioFisico;

public class EventMapper {

	private EventMapper() {
	}

	public static EventCrearEspacio Domain2EventCrearEspacio(EspacioFisico entidad) {
		EventCrearEspacio event = new EventCrearEspacio();
		event.setNombre(entidad.getNombre());
		event.setDireccion(entidad.getDireccion());
		event.setPropietario(entidad.getPropietario());
		event.setCapacidad(entidad.getCapacidad());
		event.setCancelado(entidad.isCancelado());

		return event;
	}

	public static EventModificarEspacio Domain2EventModificarEspacio(EspacioFisico entidad) {
		EventModificarEspacio event = new EventModificarEspacio();
		event.setNombre(entidad.getNombre());
		event.setCapacidad(entidad.getCapacidad());

		return event;
	}

	public static EventModificarEstadoEspacio Domain2EventModificarEstadoEspacio(boolean estado) {
		EventModificarEstadoEspacio event = new EventModificarEstadoEspacio();
		event.setCancelado(estado);

		return event;
	}
}
