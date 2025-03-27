package reservas.servicio;

public interface IServicioEventos {

	void crearEvento(String idEvento, int capacidad, boolean cancelado);

	void modificarEvento(String idEvento, int capacidad);

	void cancelarEvento(String idEvento);
}
