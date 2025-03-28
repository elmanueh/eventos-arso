package espacios.communication.producer;

import java.time.LocalDateTime;

import espacios.communication.EventMapper;
import espacios.communication.RabbitEvent;
import espacios.communication.RabbitMQConfig;
import espacios.modelo.EspacioFisico;

public class RabbitMQProducer implements IEventProducer {

	public static final String ESPACIO_CREADO = "espacio.creado";
	public static final String ESPACIO_MODIFICADO = "espacio.modificado";
	public static final String ESPACIO_ESTADO_MODIFICADO = "espacio.estado_modificado";

	@Override
	public void publicarEspacioCreado(String idEntidad, EspacioFisico entidad) {
		RabbitEvent event = EventMapper.Domain2EventCrearEspacio(entidad);
		event.setIdEntidad(idEntidad);
		event.setFechaHora(LocalDateTime.now());
		event.setTipoEvento(RabbitMQProducer.ESPACIO_CREADO);

		RabbitMQConfig.getInstance().publishEvent(event);
	}

	@Override
	public void publicarEspacioModificado(String idEntidad, EspacioFisico entidad) {
		RabbitEvent event = EventMapper.Domain2EventModificarEspacio(entidad);
		event.setIdEntidad(idEntidad);
		event.setFechaHora(LocalDateTime.now());
		event.setTipoEvento(RabbitMQProducer.ESPACIO_MODIFICADO);

		RabbitMQConfig.getInstance().publishEvent(event);
	}

	@Override
	public void publicarEspacioEstadoModificado(String idEntidad, boolean estado) {
		RabbitEvent event = EventMapper.Domain2EventModificarEstadoEspacio(estado);
		event.setIdEntidad(idEntidad);
		event.setFechaHora(LocalDateTime.now());
		event.setTipoEvento(RabbitMQProducer.ESPACIO_ESTADO_MODIFICADO);

		RabbitMQConfig.getInstance().publishEvent(event);
	}

}
