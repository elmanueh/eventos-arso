package reservas.communication.producer;

import java.util.UUID;

import reservas.modelo.Reserva;

public interface IEventProducer {

	void publicarReservaCreado(UUID idEntidad, Reserva entidad);

}
