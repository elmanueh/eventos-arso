package eventos.servicio.reservas;


import java.io.IOException;

import org.springframework.stereotype.Component;

import eventos.servicio.reservas.exception.RetrofitException;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Component
public class ServicioReservasAPI implements IServicioReservasAPI {

	private final Retrofit retrofit;
	private final ReservasRest reservasRest;
	
	public ServicioReservasAPI() {
		retrofit = new Retrofit.Builder().baseUrl("http://localhost:8083/api/")
				.addConverterFactory(JacksonConverterFactory.create()).build();
		reservasRest = retrofit.create(ReservasRest.class);
	}

	@Override
	public int validadReservas(String idEvento) throws RetrofitException {
		try {
			return reservasRest.obtenerPlazasReservadas(idEvento).execute().body();
		} catch (IOException e) {
			throw new RetrofitException("Error al consultar las plazas reservadas del evento con id " + idEvento);
		}
	}

	

}
