package espacios.servicio.eventos;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import espacios.servicio.eventos.exception.RetrofitException;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServicioEventosAPI implements IServicioEventosAPI {

	private final Retrofit retrofit;
	private final EventosRest eventosRest;

	public ServicioEventosAPI() {
		retrofit = new Retrofit.Builder().baseUrl("http://localhost:8082/api/")
				.addConverterFactory(GsonConverterFactory.create()).build();
		eventosRest = retrofit.create(EventosRest.class);
	}

	@Override
	public boolean isAlgunaOcupacion(UUID idEspacio) throws RetrofitException {
		try {
			Boolean response = eventosRest.isAlgunaOcupacion(idEspacio).execute().body();
			return response.booleanValue();
		} catch (IOException e) {
			throw new RetrofitException("Error al consultar la ocupación del espacio físico con id " + idEspacio);
		}
	}

	@Override
	public List<UUID> buscarEspaciosFisicosLibres(LocalDateTime fechaInicio, LocalDateTime fechaFin,
			int capacidad) throws RetrofitException {
		try {
			List<UUID> response = eventosRest
					.buscarEspaciosFisicosLibres(fechaInicio.toString(), fechaFin.toString(), capacidad)
					.execute().body();

			return response;
		} catch (Exception e) {
			System.out.println(e);
			throw new RetrofitException("Error al buscar espacios físicos libres");
		}
	}

	@Override
	public int validarCapacidad(UUID idEspacioFisico) throws RetrofitException {
		try {
			return eventosRest.obtenerNumPlazasMayor(idEspacioFisico).execute().body().intValue();
		} catch (IOException e) {
			throw new RetrofitException("Error al consultar el número de plazas mayor de un evento en el espacio físico con id " + idEspacioFisico);
		}
	}

}
