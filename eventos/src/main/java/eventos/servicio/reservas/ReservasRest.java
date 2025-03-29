package eventos.servicio.reservas;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ReservasRest {

	@GET("reservas/evento/{idEvento}/plazasReservadas")
	Call<Integer> obtenerPlazasReservadas(@Path("idEvento") String idEvento);
}
