package eventos.communication.producer;

import java.util.UUID;

import eventos.modelo.Evento;

public interface IEventProducer {

	void publicarEventoCreado(UUID idEntidad, Evento entidad);

	void publicarEventoModificado(UUID idEntidad, Evento entidad);

	void publicarEventoCancelado(UUID idEntidad);

}
