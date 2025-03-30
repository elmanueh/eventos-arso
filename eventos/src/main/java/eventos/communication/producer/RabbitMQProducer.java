package eventos.communication.producer;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eventos.communication.EventMapper;
import eventos.communication.RabbitEvent;
import eventos.communication.RabbitMQConfig;
import eventos.modelo.Evento;

@Component
public class RabbitMQProducer implements IEventProducer {

	public static final String EVENTO_CREADO = "evento.creado";
	public static final String EVENTO_MODIFICADO = "evento.modificado";
	public static final String EVENTO_CANCELADO = "evento.cancelado";

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Override
	public void publicarEventoCreado(UUID idEntidad, Evento entidad) {
		RabbitEvent event = EventMapper.Domain2EventCrearEvento(entidad);
		event.setIdEntidad(entidad.getId());
		event.setFechaHora(LocalDateTime.now());
		event.setTipoEvento(RabbitMQProducer.EVENTO_CREADO);

		rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME,
				RabbitMQConfig.generarRoutingKey(EVENTO_CREADO), event);
	}

	@Override
	public void publicarEventoModificado(UUID idEntidad, Evento entidad) {
		RabbitEvent event = EventMapper.Domain2EventModificarEvento(entidad);
		event.setIdEntidad(entidad.getId());
		event.setFechaHora(LocalDateTime.now());
		event.setTipoEvento(RabbitMQProducer.EVENTO_MODIFICADO);

		rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME,
				RabbitMQConfig.generarRoutingKey(EVENTO_MODIFICADO), event);
	}

	@Override
	public void publicarEventoCancelado(UUID idEntidad) {
		RabbitEvent event = EventMapper.Domain2EventCancelarEvento(idEntidad);
		event.setIdEntidad(idEntidad);
		event.setFechaHora(LocalDateTime.now());
		event.setTipoEvento(RabbitMQProducer.EVENTO_CANCELADO);

		rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME,
				RabbitMQConfig.generarRoutingKey(EVENTO_CANCELADO), event);
	}

}
