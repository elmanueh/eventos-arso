package eventos.servicio;

public interface IServicioEspacios {

	void crearEspacio(String idEspacio, String nombre, String propietario, String direccion, boolean cancelado,
			int capacidad);

	void modificarEspacio(String idEspacio, String nombre, int capacidad);

	void cambiarEstadoEspacio(String idEspacio, boolean isCancelado);

}
