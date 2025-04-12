package eventos.communication.consumer;

import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import eventos.communication.RabbitMQConfig;
import eventos.communication.consumer.events.EventCambiarEstadoEspacio;
import eventos.communication.consumer.events.EventCrearEspacio;
import eventos.communication.consumer.events.EventModificarEspacio;
import eventos.servicio.IServicioEspacios;

@Service
public class RabbitMQConsumer implements IEventConsumer {

	public static final String ESPACIO_CREADO = "espacio.creado";
	public static final String ESPACIO_MODIFICADO = "espacio.modificado";
	public static final String ESPACIO_CAMBIAR_ESTADO = "espacio.estado_modificado";

	private final IServicioEspacios servicio;
	private final ObjectMapper objectMapper;

	public RabbitMQConsumer(IServicioEspacios servicio) {
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
				case ESPACIO_CREADO:
					EventCrearEspacio eventCreado = objectMapper.convertValue(eventData, EventCrearEspacio.class);
					servicio.crearEspacio(eventCreado.getIdEntidad(), eventCreado.isCancelado(), eventCreado.getCapacidad());
					break;

				case ESPACIO_MODIFICADO:
					EventModificarEspacio eventModificado = objectMapper.convertValue(eventData,
							EventModificarEspacio.class);
					servicio.modificarEspacio(eventModificado.getIdEntidad(), eventModificado.getCapacidad());
					break;
				case ESPACIO_CAMBIAR_ESTADO:
					EventCambiarEstadoEspacio eventCambiadoEstado = objectMapper.convertValue(eventData,
							EventCambiarEstadoEspacio.class);
					servicio.cambiarEstadoEspacio(eventCambiadoEstado.getIdEntidad(),
							eventCambiadoEstado.isCancelado());
					break;

			}

		} catch (Exception e) {
			System.out.println("Error al procesar el evento: " + e.getMessage());
		}

	}
}
