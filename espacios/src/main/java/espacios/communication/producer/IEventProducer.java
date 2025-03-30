package espacios.communication.producer;

import java.util.UUID;

import espacios.modelo.EspacioFisico;

public interface IEventProducer {

	void publicarEspacioCreado(UUID idEntidad, EspacioFisico entidad);

	void publicarEspacioModificado(UUID idEntidad, EspacioFisico entidad);

	void publicarEspacioEstadoModificado(UUID idEntidad, boolean estado);

}
