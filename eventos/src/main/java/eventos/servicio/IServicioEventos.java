package eventos.servicio;

import java.time.LocalDateTime;

import eventos.modelo.EventoCategoria;

public interface IServicioEventos {

	String altaEvento(String nombre, String descripcion, String organizador, EventoCategoria categoria,
			LocalDateTime fechaInicio, LocalDateTime fechaFin, int numPlazas, String idEspacioFisico);

	void modificarEvento(String idEvento, String descripcion, LocalDateTime fechaInicio, LocalDateTime fechaFin,
			int numPlazas, String idEspacioFisico);

	void cancelarEvento(String idEvento);

	String eventosDelMes(int mes, int año);

}
