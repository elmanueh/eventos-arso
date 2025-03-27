package reservas.communication.consumer;

import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import reservas.communication.RabbitMQConfig;
import reservas.communication.consumer.events.EventCancelarEvento;
import reservas.communication.consumer.events.EventCrearEvento;
import reservas.communication.consumer.events.EventModificarEvento;
import reservas.servicio.IServicioEventos;

@Service
public class RabbitMQConsumer implements IEventConsumer {

	public static final String EVENTO_CREADO = "evento.creado";
	public static final String EVENTO_MODIFICADO = "evento.modificado";
	public static final String EVENTO_CANCELADO = "evento.cancelado";

	private final IServicioEventos servicio;
	private final ObjectMapper objectMapper;

	public RabbitMQConsumer(IServicioEventos servicio) {
		this.servicio = servicio;

		this.objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	@RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
	@Override
	public void procesarEventoHandler(Map<String, Object> eventData) {
		try {
			String tipoEvento = (String) eventData.get("tipoEvento");

			switch (tipoEvento) {
				case EVENTO_CREADO:
					EventCrearEvento eventCreado = objectMapper.convertValue(eventData, EventCrearEvento.class);
					servicio.crearEvento(eventCreado.getIdEntidad(), eventCreado.getCapacidad(),
							eventCreado.isCancelado());
					break;

				case EVENTO_MODIFICADO:
					EventModificarEvento eventModificado = objectMapper.convertValue(eventData,
							EventModificarEvento.class);
					servicio.modificarEvento(eventModificado.getIdEntidad(),
							eventModificado.getNumPlazas());
					break;
				case EVENTO_CANCELADO:
					EventCancelarEvento eventCancelado = objectMapper.convertValue(eventData,
							EventCancelarEvento.class);
					servicio.cancelarEvento(eventCancelado.getIdEntidad());
					break;
			}

		} catch (Exception e) {
			System.out.println("Error al procesar el evento: " + e.getMessage());
		}

	}
}
