package eventos.servicio.reservas;

import java.util.UUID;

import eventos.servicio.reservas.exception.ServicioReservasException;

public interface IServicioReservasAPI {
	int obtenerPlazasReservadas(UUID idEvento) throws ServicioReservasException;

}