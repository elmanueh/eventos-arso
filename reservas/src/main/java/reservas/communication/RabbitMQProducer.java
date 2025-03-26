package reservas.communication;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQProducer implements IEventProducer {

	private static final String RESERVA_CREADO = "reserva.creado";

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Override
	public void publicarReservaCreado(String idEntidad, Object entidad) {
		// ReservaDTO reserva = new ReservaDTO(idEntidad, RESERVA_CREADO, entidad);
		//
		// rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME,
		// RabbitMQConfig.generarRoutingKey(RESERVA_CREADO), reserva);
		//
		// System.out.println("Mensaje enviado: " + reserva.toString());
	}

}
