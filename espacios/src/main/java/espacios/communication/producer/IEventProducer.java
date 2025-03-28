package espacios.communication.producer;

import espacios.modelo.EspacioFisico;

public interface IEventProducer {

	void publicarEspacioCreado(String idEntidad, EspacioFisico entidad);

	void publicarEspacioModificado(String idEntidad, EspacioFisico entidad);

	void publicarEspacioEstadoModificado(String idEntidad, boolean estado);

}
