package reservas.servicio;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import reservas.modelo.Reserva;
import reservas.repositorio.exception.EntidadNoEncontrada;
import reservas.rest.dto.ReservaResumen;

public interface IServicioReservas {

	UUID reservar(UUID idEvento, UUID idUsuario, int numPlazas) throws EntidadNoEncontrada;

	Reserva recuperarReserva(UUID idReserva) throws EntidadNoEncontrada;

	Page<ReservaResumen> recuperarTodasReservas(UUID idEvento, Pageable pageable) throws EntidadNoEncontrada;

	int recuperarNumPlazasReservadas(UUID idEvento) throws EntidadNoEncontrada;

	Page<ReservaResumen> recuperarReservasPorUsuario(UUID idUsuario, Pageable pageable) throws EntidadNoEncontrada;
}
