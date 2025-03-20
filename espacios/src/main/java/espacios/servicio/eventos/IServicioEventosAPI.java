package espacios.servicio.eventos;

import java.time.LocalDateTime;
import java.util.List;

import espacios.servicio.eventos.exception.RetrofitException;

public interface IServicioEventosAPI {

	boolean isAlgunaOcupacion(String idEspacio) throws RetrofitException;

	List<String> buscarEspaciosFisicosLibres(LocalDateTime fechaInicio, LocalDateTime fechaFin, int capacidad)
			throws RetrofitException;
}