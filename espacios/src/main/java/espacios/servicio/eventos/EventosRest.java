package espacios.servicio.eventos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface EventosRest {

	@GET("eventos/ocupacion/{id}")
	Call<Boolean> isAlgunaOcupacion(@Path("id") String idEspacio);

	@GET("eventos/espacioslibres")
	Call<List<String>> buscarEspaciosFisicosLibres(
			@Query("fechaInicio") String fechaInicio,
			@Query("fechaFin") String fechaFin,
			@Query("capacidad") int capacidad);
}
