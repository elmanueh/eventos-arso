package reservas.communication.mapper;

import reservas.communication.dto.CrearEventoDto;
import reservas.communication.dto.ModificarEventoDto;
import reservas.modelo.Evento;

public class EventoMapper {

	private EventoMapper() {
	}

	public static Evento Domain2CrearEventoDto(CrearEventoDto eventoDto) {
		Evento evento = new Evento();
		return evento;
	}

	public static Evento Domain2ModificarEventoDto(ModificarEventoDto eventoDto) {
		Evento evento = new Evento();
		return evento;
	}

}
