package eventos.communication;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eventos.communication.dto.CrearEventoDto;
import eventos.communication.dto.ModificarEventoDto;
import eventos.communication.mapper.EventoMapper;
import eventos.modelo.Evento;

@Component
public class RabbitMQProducer implements IEventProducer {

	private static final String EVENTO_CREADO = "evento.creado";
	private static final String EVENTO_MODIFICADO = "evento.modificado";
	private static final String EVENTO_CANCELADO = "evento.cancelado";

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Override
	public void publicarEventoCreado(String idEntidad, Evento entidad) {
		Event<CrearEventoDto> evento = new Event<>(idEntidad, EVENTO_CREADO,
				EventoMapper.Domain2CrearEventoDto(entidad));

		rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME,
				RabbitMQConfig.generarRoutingKey(EVENTO_CREADO), evento);

		System.out.println("Mensaje enviado: " + evento.toString());
	}

	@Override
	public void publicarEventoModificado(String idEntidad, Evento entidad) {
		Event<ModificarEventoDto> evento = new Event<>(idEntidad, EVENTO_MODIFICADO,
				EventoMapper.Domain2ModificarEventoDto(entidad));

		rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME,
				RabbitMQConfig.generarRoutingKey(EVENTO_MODIFICADO), evento);

		System.out.println("Mensaje enviado: " + evento.toString());
	}

	@Override
	public void publicarEventoCancelado(String idEntidad) {
		Event<Void> evento = new Event<>(idEntidad, EVENTO_CANCELADO);

		rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME,
				RabbitMQConfig.generarRoutingKey(EVENTO_CANCELADO), evento);

		System.out.println("Mensaje enviado: " + evento.toString());
	}

}
