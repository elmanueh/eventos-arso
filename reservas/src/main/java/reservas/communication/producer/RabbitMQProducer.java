package reservas.communication.producer;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import reservas.communication.EventMapper;
import reservas.communication.RabbitEvent;
import reservas.communication.RabbitMQConfig;
import reservas.modelo.Reserva;

@Component
public class RabbitMQProducer implements IEventProducer {

	public static final String RESERVA_CREADO = "reserva.creado";

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Override
	public void publicarReservaCreado(UUID idEntidad, Reserva entidad) {
		RabbitEvent event = EventMapper.Domain2EventCrearReserva(entidad);
		event.setIdEntidad(idEntidad);
		event.setFechaHora(LocalDateTime.now());
		event.setTipoEvento(RabbitMQProducer.RESERVA_CREADO);

		rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME,
				RabbitMQConfig.generarRoutingKey(RESERVA_CREADO), event);
	}

}
