package eventos.servicio;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import eventos.modelo.Evento;
import eventos.modelo.EventoCategoria;
import eventos.repositorio.EntidadNoEncontrada;

public interface IServicioEventos {

	Evento recuperarEvento(String idEvento) throws EntidadNoEncontrada;

	String altaEvento(String nombre, String descripcion, String organizador, EventoCategoria categoria,
			LocalDateTime fechaInicio, LocalDateTime fechaFin, int numPlazas, String idEspacioFisico)
			throws EntidadNoEncontrada;

	void modificarEvento(String idEvento, String descripcion, LocalDateTime fechaInicio, LocalDateTime fechaFin,
			int numPlazas, String idEspacioFisico) throws EntidadNoEncontrada;

	void cancelarEvento(String idEvento);

	String eventosDelMes(int mes, int año);

	Page<EventoResumen> eventosDelMesPaginados(int mes, int año, Pageable pageable);
}
