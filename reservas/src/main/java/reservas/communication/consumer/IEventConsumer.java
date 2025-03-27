package reservas.communication.consumer;

import java.util.Map;

public interface IEventConsumer {

	void procesarEventoHandler(Map<String, Object> eventData);

}
