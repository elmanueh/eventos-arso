package eventos.servicio;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import eventos.modelo.Evento;
import eventos.modelo.EventoCategoria;
import eventos.repositorio.exception.EntidadNoEncontrada;
import eventos.rest.dto.EventoResumen;
import eventos.servicio.reservas.exception.RetrofitException;

public interface IServicioEventos {

	Evento recuperarEvento(String idEvento) throws EntidadNoEncontrada;

	String altaEvento(String nombre, String descripcion, String organizador, EventoCategoria categoria,
			LocalDateTime fechaInicio, LocalDateTime fechaFin, int numPlazas, String idEspacioFisico)
			throws EntidadNoEncontrada;

	void modificarEvento(String idEvento, String descripcion, LocalDateTime fechaInicio, LocalDateTime fechaFin,
			int numPlazas, String idEspacioFisico) throws EntidadNoEncontrada, RetrofitException;

	void cancelarEvento(String idEvento);

	Page<EventoResumen> eventosDelMesPaginados(int mes, int año, Pageable pageable);

	boolean isAlgunaOcupacion(String idEspacio);

	List<String> buscarEspaciosFisicosLibres(LocalDateTime fechaInicio, LocalDateTime fechaFin, int capacidad);

}
