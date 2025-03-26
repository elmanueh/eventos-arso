package reservas.communication;

import reservas.communication.dto.CrearEventoDto;

public interface IEventConsumer {

	void procesarEventoCreado(Event<CrearEventoDto> evento);

}
