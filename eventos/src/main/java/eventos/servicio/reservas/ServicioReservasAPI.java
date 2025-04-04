package eventos.servicio.reservas;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import eventos.servicio.reservas.exception.RetrofitException;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Component
public class ServicioReservasAPI implements IServicioReservasAPI {

	private final Retrofit retrofit;
	private final ReservasRest reservasRest;
	private final String RESERVAS_URL;

	public ServicioReservasAPI(@Value("${RESERVAS_URL}") String reservasUrl) {
		this.RESERVAS_URL = reservasUrl;
		retrofit = new Retrofit.Builder().baseUrl(RESERVAS_URL)
				.addConverterFactory(JacksonConverterFactory.create()).build();
		reservasRest = retrofit.create(ReservasRest.class);
	}

	@Override
	public int validadReservas(UUID idEvento) throws RetrofitException {
		try {
			return reservasRest.obtenerPlazasReservadas(idEvento).execute().body();
		} catch (IOException e) {
			throw new RetrofitException("Error al consultar las plazas reservadas del evento con id " + idEvento);
		}
	}

}
