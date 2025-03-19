package espacios.servicio.eventos;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import espacios.modelo.EspacioFisico;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServicioEventos implements IServicioEventos {

	private final Retrofit retrofit;
	private final EventosRest eventosRest;

	public ServicioEventos() {
		retrofit = new Retrofit.Builder().baseUrl("http://localhost:8081/api/")
				.addConverterFactory(GsonConverterFactory.create()).build();
		eventosRest = retrofit.create(EventosRest.class);
	}

	@Override
	public boolean isAlgunaOcupacion(String idEspacio) {
		try {
			Boolean response = eventosRest.isAlgunaOcupacion(idEspacio).execute().body();
			return response.booleanValue();
		} catch (IOException e) {
			return false;
		}
	}

	@Override
	public List<EspacioFisico> buscarEspaciosFisicosLibres(LocalDateTime fechaInicio, LocalDateTime fechaFin,
			int capacidad) {
		try {
			List<EspacioFisico> response = eventosRest
					.buscarEspaciosFisicosLibres(fechaInicio.toString(), fechaFin.toString(), capacidad).execute()
					.body();

			return response;
		} catch (Exception e) {
			return new LinkedList<EspacioFisico>();
		}
	}

}
