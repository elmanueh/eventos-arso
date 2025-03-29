package eventos.servicio;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import eventos.communication.producer.IEventProducer;
import eventos.modelo.EspacioFisico;
import eventos.modelo.Evento;
import eventos.modelo.EventoCategoria;
import eventos.repositorio.RepositorioEspacios;
import eventos.repositorio.RepositorioEventos;
import eventos.repositorio.exception.EntidadNoEncontrada;
import eventos.rest.dto.EventoResumen;
import eventos.rest.mapper.EventoMapper;
import eventos.servicio.reservas.IServicioReservasAPI;
import eventos.servicio.reservas.exception.RetrofitException;

@Service
@Transactional
public class ServicioEventos implements IServicioEventos {

	private final RepositorioEventos repositorioEvento;
	private final RepositorioEspacios repositorioEspacio;
	private final IEventProducer eventosPublisher;
	private final IServicioReservasAPI servicioReservasAPI;

	@Autowired
	public ServicioEventos(RepositorioEventos repositorioEvento, RepositorioEspacios repositorioEspacios,
			IEventProducer eventosPublisher, IServicioReservasAPI servicioReservasAPI) {
		this.repositorioEvento = repositorioEvento;
		this.repositorioEspacio = repositorioEspacios;
		this.eventosPublisher = eventosPublisher;
		this.servicioReservasAPI = servicioReservasAPI;
	}

	// USUARIO
	@Override
	public Evento recuperarEvento(String idEvento) throws EntidadNoEncontrada {
		if (idEvento == null || idEvento.isEmpty())
			throw new IllegalArgumentException("id: no debe ser nulo ni vacio");

		Optional<Evento> resultado = repositorioEvento.findById(idEvento);

		if (!resultado.isPresent())
			throw new EntidadNoEncontrada("No existe encuesta con id: " + idEvento);
		return resultado.get();
	}

	// GESTOR_EVENTOS
	@Override
	public String altaEvento(String nombre, String descripcion, String organizador, EventoCategoria categoria,
			LocalDateTime fechaInicio, LocalDateTime fechaFin, int numPlazas, String idEspacioFisico)
			throws EntidadNoEncontrada {

		if (nombre == null || nombre.isEmpty())
			throw new IllegalArgumentException("El nombre del evento no puede ser nulo o vacío.");
		if (descripcion == null || descripcion.isEmpty())
			throw new IllegalArgumentException("La descripción del evento no puede ser nula o vacía.");
		if (organizador == null || organizador.isEmpty())
			throw new IllegalArgumentException("El organizador del evento no puede ser nulo o vacío.");
		if (categoria == null)
			throw new IllegalArgumentException("La categoría del evento no puede ser nula.");
		if (fechaInicio == null)
			throw new IllegalArgumentException("La fecha de inicio del evento no puede ser nula.");
		if (fechaFin == null)
			throw new IllegalArgumentException("La fecha de fin del evento no puede ser nula.");
		if (numPlazas <= 0)
			throw new IllegalArgumentException("El número de plazas del evento debe ser mayor que 0.");
		if (idEspacioFisico == null || idEspacioFisico.isEmpty())
			throw new IllegalArgumentException("El id del espacio físico no puede ser nulo o vacío.");

		try {
			Optional<EspacioFisico> espacioFisicoOptional = repositorioEspacio.findById(idEspacioFisico);

			if (!espacioFisicoOptional.isPresent())
				throw new EntidadNoEncontrada("Error al encontrar el evento con id " + idEspacioFisico + ".");
			EspacioFisico espacioFisico = espacioFisicoOptional.get();

			if (espacioFisico.isCancelado())
				throw new IllegalStateException("El espacio físico con id " + idEspacioFisico + " está cancelado.");

			if (numPlazas > espacioFisico.getCapacidad())
				throw new IllegalStateException(
						"El número de plazas supera la capacidad del espacio físico con id " + idEspacioFisico + ".");

			if (isAlgunaOcupacion(idEspacioFisico))
				throw new IllegalStateException(
						"El espacio físico con id " + idEspacioFisico + " tiene ocupaciones en la fecha.");

			Evento evento = new Evento(nombre, descripcion, organizador, numPlazas, categoria, fechaInicio, fechaFin,
					espacioFisico);

			String id = repositorioEvento.save(evento).getId();

			// TODO: publicar evento
			eventosPublisher.publicarEventoCreado(id, evento);

			return id;
		} catch (EntidadNoEncontrada e) {
			throw new EntidadNoEncontrada("Error al encontrar el espacio físico con id "
					+ idEspacioFisico + ".");
		}
	}

	// GESTOR_EVENTOS
	@Override
	public void modificarEvento(String idEvento, String descripcion, LocalDateTime fechaInicio, LocalDateTime fechaFin,
			int numPlazas, String idEspacioFisico) throws EntidadNoEncontrada, RetrofitException {

		if (idEvento == null || idEvento.isEmpty())
			throw new IllegalArgumentException("El id del evento no puede ser nulo o vacío.");
		if (descripcion != null && descripcion.isEmpty())
			throw new IllegalArgumentException("La descripción del evento no puede ser vacía.");
		if (numPlazas <= -1)
			throw new IllegalArgumentException("La número de plazas del evento debe ser mayor que 0.");
		if (idEspacioFisico != null && idEspacioFisico.isEmpty())
			throw new IllegalArgumentException("El id del espacio físico no puede ser vacío o nulo.");

		Optional<Evento> eventoOptional = repositorioEvento.findById(idEvento);
		if (!eventoOptional.isPresent())
			throw new EntidadNoEncontrada("Error al encontrar el evento con id " + idEvento + ".");

		Evento evento = eventoOptional.get();
		if (descripcion != null)
			evento.setDescripcion(descripcion);
		if (fechaInicio != null)
			evento.setFechaInicio(fechaInicio);
		if (fechaFin != null)
			evento.setFechaFin(fechaFin);
		if (numPlazas != 0) {
			//TODO: retrofit para cambiar numPlazas
			if (evento.getOcupacion() != null && evento.getNumPlazas() > numPlazas) {
					int numPlazasReservadas = servicioReservasAPI.validadReservas(idEvento);
					if (numPlazas < numPlazasReservadas) {
						throw new IllegalStateException("El número de plazas del evento no puede ser menor al número de plazas reservadas en el evento con id " + idEvento + ".");
					}
			}
			evento.setNumPlazas(numPlazas);
		}
		if (idEspacioFisico != null) {
			Optional<EspacioFisico> espacioFisicoOptional = repositorioEspacio.findById(idEspacioFisico);
			if (!espacioFisicoOptional.isPresent())
				throw new EntidadNoEncontrada("Error al encontrar el espacio físico con id " + idEspacioFisico + ".");

			EspacioFisico espacio = espacioFisicoOptional.get();
			evento.setEspacioFisico(espacio);
		}

		repositorioEvento.save(evento);

		// TODO: publicar evento
		eventosPublisher.publicarEventoModificado(idEvento, evento);
	}

	// GESTOR_EVENTOS
	@Override
	public void cancelarEvento(String idEvento) {

		if (idEvento == null || idEvento.isEmpty())
			throw new IllegalArgumentException("El id del evento no puede ser nulo o vacio.");

		Optional<Evento> eventoOptional = repositorioEvento.findById(idEvento);
		if (!eventoOptional.isPresent())
			throw new EntityNotFoundException("Error al encontrar el evento con id " + idEvento + ".");

		Evento evento = eventoOptional.get();
		evento.setCancelado();
		repositorioEvento.save(evento);

		// TODO: publicar evento
		eventosPublisher.publicarEventoCancelado(idEvento);
	}

	// USUARIO
	@Override
	public Page<EventoResumen> eventosDelMesPaginados(int mes, int año, Pageable pageable) {
		if (mes < 1 || mes > 12)
			throw new IllegalArgumentException("El mes debe estar comprendido entre 1 y 12.");
		if (año < 0)
			throw new IllegalArgumentException("El año no puede ser negativo.");

		return repositorioEvento.getEventosDelMesPaginados(mes, año, pageable).map(EventoMapper::toResumen);
	}

	@Override
	public boolean isAlgunaOcupacion(String idEspacio) {
		if (idEspacio == null || idEspacio.isEmpty())
			throw new IllegalArgumentException("El id del espacio físico no puede ser nulo o vacío.");

		return repositorioEspacio.getNumeroOcupaciones(idEspacio) > 0;
	}

	@Override
	public List<String> buscarEspaciosFisicosLibres(LocalDateTime fechaInicio, LocalDateTime fechaFin,
			int capacidad) {
		if (fechaInicio == null)
			throw new IllegalArgumentException("La fecha de inicio no puede ser nula.");
		if (fechaFin == null)
			throw new IllegalArgumentException("La fecha de fin no puede ser nula.");
		if (capacidad <= 0)
			throw new IllegalArgumentException("La capacidad debe ser mayor que 0.");

		return repositorioEspacio.getEspaciosFisicoLibres(fechaInicio, fechaFin, capacidad);
	}

}