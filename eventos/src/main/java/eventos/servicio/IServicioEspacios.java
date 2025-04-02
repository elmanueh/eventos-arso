package eventos.servicio;

import java.util.UUID;

public interface IServicioEspacios {

	void crearEspacio(UUID idEspacio, boolean cancelado, int capacidad);

	void modificarEspacio(UUID idEspacio, int capacidad);

	void cambiarEstadoEspacio(UUID idEspacio, boolean isCancelado);

}
