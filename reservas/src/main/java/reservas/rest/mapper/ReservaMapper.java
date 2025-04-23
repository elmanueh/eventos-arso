package reservas.rest.mapper;

import reservas.modelo.Reserva;
import reservas.rest.dto.ReservaResponseDTO;
import reservas.rest.dto.ReservaResumen;

public class ReservaMapper {

	private ReservaMapper() {
	}

	public static ReservaResponseDTO toDTO(Reserva reserva) {
		ReservaResponseDTO dto = new ReservaResponseDTO();
		dto.setId(reserva.getId());
		dto.setIdUsuario(reserva.getIdUsuario());
		dto.setPlazasReservadas(reserva.getPlazasReservadas());
		dto.setCancelada(reserva.isCancelada());
		dto.setEvento(reserva.getEvento().getId());

		return dto;
	}

	public static ReservaResumen toResumen(Reserva reserva) {
		ReservaResumen resumen = new ReservaResumen();
		resumen.setId(reserva.getId());
		resumen.setIdUsuario(reserva.getIdUsuario());
		resumen.setPlazasReservadas(reserva.getPlazasReservadas());
		resumen.setCancelada(reserva.isCancelada());

		return resumen;
	}
}