package espacios.servicio.eventos;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import espacios.servicio.eventos.exception.ServicioEventosException;
import io.github.cdimascio.dotenv.Dotenv;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServicioEventosAPI implements IServicioEventosAPI {

	private final Retrofit retrofit;
	private final EventosRest eventosRest;
	private static final Dotenv dotenv = Dotenv.load();
	private final String EVENTOS_URL = dotenv.get("EVENTOS_URL");

	public ServicioEventosAPI() {
		retrofit = new Retrofit.Builder().baseUrl(EVENTOS_URL)
				.addConverterFactory(GsonConverterFactory.create()).build();
		eventosRest = retrofit.create(EventosRest.class);
	}

	@Override
	public boolean isAlgunaOcupacion(UUID idEspacio) throws ServicioEventosException {
		try {
			return eventosRest.isAlgunaOcupacion(idEspacio).execute().body();
		} catch (IOException e) {
			throw new ServicioEventosException(
					"Error al consultar la ocupación del espacio físico con id " + idEspacio);
		}
	}

	@Override
	public List<UUID> buscarEspaciosFisicosLibres(LocalDateTime fechaInicio, LocalDateTime fechaFin,
			int capacidad) throws ServicioEventosException {
		try {
			List<UUID> response = eventosRest
					.buscarEspaciosFisicosLibres(fechaInicio.toString(), fechaFin.toString(), capacidad)
					.execute().body();

			return response;
		} catch (IOException e) {
			throw new ServicioEventosException("Error al buscar espacios físicos libres");
		}
	}

	@Override
	public int validarCapacidad(UUID idEspacioFisico) throws ServicioEventosException {
		try {
			return eventosRest.obtenerNumPlazasMayor(idEspacioFisico).execute().body();
		} catch (IOException e) {
			throw new ServicioEventosException(
					"Error al consultar el número de plazas mayor de un evento en el espacio físico con id "
							+ idEspacioFisico);
		}
	}

}
