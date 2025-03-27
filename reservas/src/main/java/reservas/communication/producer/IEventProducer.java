package reservas.communication.producer;

import reservas.modelo.Reserva;

public interface IEventProducer {

	void publicarReservaCreado(String idEntidad, Reserva entidad);

}
