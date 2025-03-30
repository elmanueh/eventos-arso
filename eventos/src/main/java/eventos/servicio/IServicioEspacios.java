package eventos.servicio;

import java.util.UUID;

public interface IServicioEspacios {

	void crearEspacio(UUID idEspacio, String nombre, String propietario, String direccion, boolean cancelado,
			int capacidad);

	void modificarEspacio(UUID idEspacio, String nombre, int capacidad);

	void cambiarEstadoEspacio(UUID idEspacio, boolean isCancelado);

}
