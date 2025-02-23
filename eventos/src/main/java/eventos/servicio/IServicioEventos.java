package eventos.servicio;

import java.time.LocalDateTime;

import eventos.modelo.Evento;
import eventos.modelo.EventoCategoria;
import eventos.repositorio.EntidadNoEncontrada;

public interface IServicioEventos {
	
	Evento recuperarEspacioFisico(String idEvento) throws EntidadNoEncontrada;

	String altaEvento(String nombre, String descripcion, String organizador, EventoCategoria categoria,
			LocalDateTime fechaInicio, LocalDateTime fechaFin, int numPlazas, String idEspacioFisico) throws EntidadNoEncontrada;

	void modificarEvento(String idEvento, String descripcion, LocalDateTime fechaInicio, LocalDateTime fechaFin,
			int numPlazas, String idEspacioFisico) throws EntidadNoEncontrada;

	void cancelarEvento(String idEvento);

	String eventosDelMes(int mes, int año);
	
}
