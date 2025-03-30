package reservas.servicio;

import java.util.UUID;

public interface IServicioEventos {

	void crearEvento(UUID idEvento, int capacidad, boolean cancelado);

	void modificarEvento(UUID idEvento, int capacidad);

	void cancelarEvento(UUID idEvento);
}
