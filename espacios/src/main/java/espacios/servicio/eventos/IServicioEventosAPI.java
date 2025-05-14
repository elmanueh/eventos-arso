package espacios.servicio.eventos;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import espacios.servicio.eventos.exception.ServicioEventosException;

public interface IServicioEventosAPI {

	boolean isAlgunaOcupacion(UUID idEspacio) throws ServicioEventosException;

	List<UUID> buscarEspaciosFisicosLibres(LocalDateTime fechaInicio, LocalDateTime fechaFin, int capacidad)
			throws ServicioEventosException;

	int validarCapacidad(UUID idEspacioFisico) throws ServicioEventosException;
}