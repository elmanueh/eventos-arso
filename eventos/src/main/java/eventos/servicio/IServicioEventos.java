package eventos.servicio;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import eventos.modelo.Evento;
import eventos.modelo.EventoCategoria;
import eventos.repositorio.exception.EntidadNoEncontrada;
import eventos.rest.dto.EventoResumen;
import eventos.servicio.reservas.exception.RetrofitException;

public interface IServicioEventos {

	Evento recuperarEvento(UUID idEvento) throws EntidadNoEncontrada;

	UUID altaEvento(String nombre, String descripcion, String organizador, EventoCategoria categoria,
			LocalDateTime fechaInicio, LocalDateTime fechaFin, int numPlazas, UUID idEspacioFisico)
			throws EntidadNoEncontrada;

	void modificarEvento(UUID idEvento, String descripcion, LocalDateTime fechaInicio, LocalDateTime fechaFin,
			int numPlazas, UUID idEspacioFisico) throws EntidadNoEncontrada, RetrofitException;

	void cancelarEvento(UUID idEvento);

	Page<EventoResumen> eventosDelMesPaginados(int mes, int año, Pageable pageable);

	boolean isAlgunaOcupacion(UUID idEspacio);

	List<UUID> buscarEspaciosFisicosLibres(LocalDateTime fechaInicio, LocalDateTime fechaFin, int capacidad);

	int numPlazasMayor(UUID idEspacioFisico);

}
