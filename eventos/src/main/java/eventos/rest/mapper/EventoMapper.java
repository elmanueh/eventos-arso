package eventos.rest.mapper;

import eventos.modelo.Evento;
import eventos.rest.dto.EventoResponseDTO;

public class EventoMapper {

	private EventoMapper() {
	}

	public static EventoResponseDTO toDTO(Evento evento) {
		EventoResponseDTO dto = new EventoResponseDTO();
		dto.setNombre(evento.getNombre());
		dto.setDescripcion(evento.getDescripcion());
		dto.setOrganizador(evento.getOrganizador());
		dto.setNumPlazas(evento.getNumPlazas());
		dto.setCancelado(evento.isCancelado());
		dto.setCategoria(evento.getCategoria().name());
		dto.setOcupado(evento.getOcupacion() != null && evento.getOcupacion().isActiva());

		return dto;
	}
}