package eventos.servicio.reservas;

import java.util.UUID;

import eventos.servicio.reservas.exception.RetrofitException;

public interface IServicioReservasAPI {
	int validadReservas(UUID idEvento) throws RetrofitException;

}