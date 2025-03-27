package eventos.communication.producer;

import eventos.modelo.Evento;

public interface IEventProducer {

	void publicarEventoCreado(String idEntidad, Evento entidad);

	void publicarEventoModificado(String idEntidad, Evento entidad);

	void publicarEventoCancelado(String idEntidad);

}
