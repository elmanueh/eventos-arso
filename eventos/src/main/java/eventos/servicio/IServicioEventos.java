package eventos.servicio;

import java.time.LocalDateTime;

import eventos.modelo.EventoCategoria;
import eventos.repositorio.EntidadNoEncontrada;
import eventos.repositorio.RepositorioException;

public interface IServicioEventos {

	String altaEvento(String nombre, String descripcion, String organizador, EventoCategoria categoria, LocalDateTime fechaInicio,
			LocalDateTime fechaFin, int numPlazas, String idEspacioFisico) throws RepositorioException, EntidadNoEncontrada;

	void modificarEvento(String idEvento, String descripcion, LocalDateTime fechaInicio, LocalDateTime fechaFin, int numPlazas, String idEspacioFisico)
			throws RepositorioException, EntidadNoEncontrada;

	void cancelarEvento(String idEvento) throws RepositorioException, EntidadNoEncontrada;

	String eventosDelMes(int mes, int año);

}
