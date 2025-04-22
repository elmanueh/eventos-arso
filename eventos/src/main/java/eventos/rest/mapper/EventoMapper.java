package eventos.rest.mapper;

import eventos.modelo.Evento;
import eventos.rest.dto.EventoResponseDTO;
import eventos.rest.dto.EventoResumen;

public class EventoMapper {

	private EventoMapper() {
	}

	public static EventoResponseDTO toDTO(Evento evento) {
		EventoResponseDTO dto = new EventoResponseDTO();
		dto.setIdEvento(evento.getId());
		dto.setNombre(evento.getNombre());
		dto.setDescripcion(evento.getDescripcion());
		dto.setOrganizador(evento.getOrganizador());
		dto.setNumPlazas(evento.getNumPlazas());
		dto.setCancelado(evento.isCancelado());
		dto.setCategoria(evento.getCategoria().name());

		dto.setEspacioFisico(evento.isCancelado() ? null : evento.getOcupacion().getEspacioFisico().getId());
		dto.setFechaInicio(evento.isCancelado() ? null : evento.getOcupacion().getFechaInicio().toString());
		dto.setFechaFin(evento.isCancelado() ? null : evento.getOcupacion().getFechaFin().toString());

		return dto;
	}

	public static EventoResumen toResumen(Evento evento) {
		EventoResumen resumen = new EventoResumen();
		resumen.setId(evento.getId());
		resumen.setNombre(evento.getNombre());
		resumen.setDescripcion(evento.getDescripcion());
		resumen.setCancelado(evento.isCancelado());
		resumen.setNumPlazas(evento.getNumPlazas());

		return resumen;
	}
}