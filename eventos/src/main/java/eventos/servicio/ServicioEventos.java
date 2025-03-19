package eventos.servicio;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import eventos.modelo.EspacioFisico;
import eventos.modelo.Evento;
import eventos.modelo.EventoCategoria;
import eventos.repositorio.EntidadNoEncontrada;
import eventos.repositorio.RepositorioEspacios;
import eventos.repositorio.RepositorioEventos;
import eventos.rest.dto.EventoResumen;
import eventos.rest.mapper.EventoMapper;

@Service
@Transactional
public class ServicioEventos implements IServicioEventos {

	private final RepositorioEventos repositorioEvento;
	private final RepositorioEspacios repositorioEspacio;

	@Autowired
	public ServicioEventos(RepositorioEventos repositorioEvento, RepositorioEspacios repositorioEspacios) {
		this.repositorioEvento = repositorioEvento;
		this.repositorioEspacio = repositorioEspacios;
	}

	// USUARIO
	@Override
	public Evento recuperarEvento(String idEvento) throws EntidadNoEncontrada {
		if (idEvento == null || idEvento.isEmpty())
			throw new IllegalArgumentException("id: no debe ser nulo ni vacio");

		Optional<Evento> resultado = repositorioEvento.findById(idEvento);

		if (resultado.isPresent() == false)
			throw new EntidadNoEncontrada("No existe encuesta con id: " + idEvento);
		else
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
			Optional<EspacioFisico> espacio2 = repositorioEspacio.findById(idEspacioFisico);

			if (!espacio2.isPresent())
				throw new EntidadNoEncontrada("Error al encontrar el evento con id " + espacio2 + ".");
			EspacioFisico espacioFisico = espacio2.get();

			if (espacioFisico.isCancelado())
				throw new IllegalStateException("El espacio físico con id " + idEspacioFisico + " está cancelado.");

			if (numPlazas > espacioFisico.getCapacidad())
				throw new IllegalStateException(
						"El número de plazas supera la capacidad del espacio físico con id " + idEspacioFisico + ".");

			// TODO: Una consulta booleana mejor
			LinkedList<EspacioFisico> espaciosFisicos = new LinkedList<EspacioFisico>(
					repositorioEspacio.getEspaciosFisicoLibres(fechaInicio, fechaFin, numPlazas));

			boolean isEspacioFisicoLibre = espaciosFisicos.stream()
					.anyMatch(espacio -> espacio.getId().equals(idEspacioFisico));

			if (!isEspacioFisicoLibre)
				throw new IllegalStateException(
						"El espacio fisico con id " + idEspacioFisico + " no está disponible en la fecha.");

			Evento evento = new Evento(nombre, descripcion, organizador, numPlazas, categoria, fechaInicio, fechaFin,
					espacioFisico);

			String id = repositorioEvento.save(evento).getId();

			return id;

		} catch (EntidadNoEncontrada e) {
			throw new EntidadNoEncontrada("Error al encontrar el espacio físico con id "
					+ idEspacioFisico + ".");
		}

	}

	// GESTOR_EVENTOS
	@Override
	public void modificarEvento(String idEvento, String descripcion, LocalDateTime fechaInicio, LocalDateTime fechaFin,
			int numPlazas, String idEspacioFisico) throws EntidadNoEncontrada {

		if (idEvento == null || idEvento.isEmpty())
			throw new IllegalArgumentException("El id del evento no puede ser nulo o vacío.");
		if (descripcion != null && descripcion.isEmpty())
			throw new IllegalArgumentException("La descripción del evento no puede ser vacía.");
		if (numPlazas <= -1)
			throw new IllegalArgumentException("La capacidad del espacio físico debe ser mayor que 0.");
		if (idEspacioFisico != null && idEspacioFisico.isEmpty())
			throw new IllegalArgumentException("El id del espacio físico no puede ser vacío.");

		Optional<Evento> evento2 = repositorioEvento.findById(idEvento);
		if (!evento2.isPresent())
			throw new EntidadNoEncontrada("Error al encontrar el evento con id " + idEvento + ".");

		Evento evento = evento2.get();
		if (descripcion != null)
			evento.setDescripcion(descripcion);
		if (fechaInicio != null)
			evento.setFechaInicio(fechaInicio);
		if (fechaFin != null)
			evento.setFechaFin(fechaFin);
		if (numPlazas != 0)
			evento.setNumPlazas(numPlazas);
		if (idEspacioFisico != null) {
			Optional<EspacioFisico> espacio2 = repositorioEspacio.findById(idEspacioFisico);

			if (!espacio2.isPresent())
				throw new EntidadNoEncontrada("Error al encontrar el evento con id " + espacio2 + ".");

			EspacioFisico espacio = espacio2.get();
			espacio.setId(idEspacioFisico);
			evento.setEspacioFisico(espacio);
		}

		repositorioEvento.save(evento);
	}

	// GESTOR_EVENTOS
	@Override
	public void cancelarEvento(String idEvento) {

		if (idEvento == null || idEvento.isEmpty())
			throw new IllegalArgumentException("El id del evento no puede ser nulo o vacio.");

		Optional<Evento> evento2 = repositorioEvento.findById(idEvento);
		if (!evento2.isPresent())
			throw new EntityNotFoundException("Error al encontrar el evento con id " + idEvento + ".");

		Evento evento = evento2.get();
		evento.setCancelado();
		repositorioEvento.save(evento);
	}

	// USUARIO
	@Override
	public String eventosDelMes(int mes, int año) {
		if (mes < 1 || mes > 12)
			throw new IllegalArgumentException("El mes debe estar comprendido entre 1 y 12.");
		if (año < 0)
			throw new IllegalArgumentException("El año no puede ser negativo.");

		List<Evento> eventos = repositorioEvento.getEventosDelMes(mes, año);
		String resumenEventos = eventos.stream().map(Evento::toString).collect(Collectors.joining(""));
		return resumenEventos;
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
	public List<EspacioFisico> buscarEspaciosFisicosLibres(LocalDateTime fechaInicio, LocalDateTime fechaFin,
			int capacidad) {
		if (fechaInicio == null)
			throw new IllegalArgumentException("La fecha de inicio no puede ser nula.");
		if (fechaFin == null)
			throw new IllegalArgumentException("La fecha de fin no puede ser nula.");
		if (capacidad <= 0)
			throw new IllegalArgumentException("La capacidad debe ser mayor que 0.");

		// TODO: Tal vez haya que paginarlo
		return repositorioEspacio.getEspaciosFisicoLibres(fechaInicio, fechaFin, capacidad);
	}

}