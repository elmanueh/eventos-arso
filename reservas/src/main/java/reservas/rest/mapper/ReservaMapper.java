package reservas.rest.mapper;

import reservas.modelo.Reserva;
import reservas.rest.dto.ReservaResponseDTO;

public class ReservaMapper {

	private ReservaMapper() {
	}

	public static ReservaResponseDTO toDTO(Reserva reserva) {
		ReservaResponseDTO dto = new ReservaResponseDTO();
		dto.setIdUsuario(reserva.getIdUsuario());
		dto.setPlazasReservadas(reserva.getPlazasReservadas());
		dto.setCancelada(reserva.isCancelada());

		return dto;
	}
}