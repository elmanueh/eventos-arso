package reservas.communication;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import reservas.communication.dto.CrearEventoDto;
import reservas.communication.dto.ModificarEventoDto;

@Service
public class RabbitMQConsumer implements IEventConsumer {

	@RabbitListener(queues = RabbitMQConfig.EVENTOS_QUEUE_NAME)
	@Override
	public void procesarEventoCreado(Event<CrearEventoDto> evento) {
		System.out.println("Mensaje recibido");
		System.out.println(evento.toString());
	}

}
