package reservas.servicio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import reservas.rest.dto.ReservaResumen;
import reservas.modelo.Reserva;
import reservas.repositorio.exception.EntidadNoEncontrada;

public interface IServicioReservas {

	String reservar(String idEvento, String idUsuario, int numPlazas) throws EntidadNoEncontrada;

	Reserva recuperarReserva(String idReserva) throws EntidadNoEncontrada;

	Page<ReservaResumen> recuperarTodasReservas(String idEvento, Pageable pageable) throws EntidadNoEncontrada;

}
