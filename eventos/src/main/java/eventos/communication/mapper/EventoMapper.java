package eventos.communication.mapper;

import eventos.communication.dto.CrearEventoDto;
import eventos.communication.dto.ModificarEventoDto;
import eventos.modelo.Evento;

public class EventoMapper {

	private EventoMapper() {
	}

	public static CrearEventoDto Domain2CrearEventoDto(Evento evento) {
		CrearEventoDto crearEventoDto = new CrearEventoDto();
		crearEventoDto.setPlazasDisponibles(evento.getNumPlazas());
		return crearEventoDto;
	}

	public static ModificarEventoDto Domain2ModificarEventoDto(Evento evento) {
		ModificarEventoDto modificarEventoDto = new ModificarEventoDto();
		return modificarEventoDto;
	}

}
