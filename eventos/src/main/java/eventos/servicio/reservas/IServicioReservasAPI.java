package eventos.servicio.reservas;

import eventos.servicio.reservas.exception.RetrofitException;

public interface IServicioReservasAPI {
	int validadReservas(String idEvento)  throws RetrofitException ;
	
}