package eventos.servicio;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eventos.modelo.Evento;
import eventos.modelo.EventoCategoria;
import eventos.repositorio.RepositorioEventos;

@Service
@Transactional
public class ServicioEventos implements IServicioEventos {

	private RepositorioEventos repositorioEvento;

	@Autowired
	public ServicioEventos(RepositorioEventos repositorio) {
		this.repositorioEvento = repositorio;
	}

	@Override
	public String altaEvento(String nombre, String descripcion, String organizador, EventoCategoria categoria,
			LocalDateTime fechaInicio, LocalDateTime fechaFin, int numPlazas, String idEspacioFisico) {

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

		// try {
		// EspacioFisico espacioFisico = repositorioEspacio.findById(idEspacioFisico);
		// if (espacioFisico.isCancelado())
		// throw new IllegalArgumentException("El espacio físico con id " +
		// idEspacioFisico + " está cancelado.");
		// if (numPlazas > espacioFisico.getCapacidad())
		// throw new IllegalArgumentException(
		// "El número de plazas supera la capacidad del espacio físico con id " +
		// idEspacioFisico + ".");
		// LinkedList<EspacioFisico> espaciosFisicos = new LinkedList<EspacioFisico>(
		// repositorioEspacio.getEspaciosFisicoLibres(fechaInicio, fechaFin,
		// numPlazas));
		// boolean isEspacioFisicoLibre = espaciosFisicos.stream()
		// .anyMatch(espacio -> espacio.getId().equals(idEspacioFisico));
		// if (!isEspacioFisicoLibre)
		// throw new IllegalArgumentException(
		// "El espacio fisico con id " + idEspacioFisico + " no está disponible en la
		// fecha.");
		// Evento evento = new Evento(nombre, descripcion, organizador, numPlazas,
		// categoria, fechaInicio, fechaFin,
		// espacioFisico);
		// String id = repositorioEvento.add(evento);
		// return id;
		// } catch (RepositorioException e) {
		// throw new RepositorioException("Error al dar de alta el evento con nombre " +
		// nombre + ".");
		// } catch (EntidadNoEncontrada e) {
		// throw new EntidadNoEncontrada("Error al encontrar el espacio físico con id "
		// + idEspacioFisico + ".");
		// }

		return "";
	}

	@Override
	public void modificarEvento(String idEvento, String descripcion, LocalDateTime fechaInicio, LocalDateTime fechaFin,
			int numPlazas, String idEspacioFisico) {

		if (idEvento == null || idEvento.isEmpty())
			throw new IllegalArgumentException("El id del evento no puede ser nulo o vacío.");
		if (descripcion != null && descripcion.isEmpty())
			throw new IllegalArgumentException("La descripción del evento no puede ser vacía.");
		if (numPlazas == 0 && numPlazas < -1)
			throw new IllegalArgumentException("El número de plazas del evento debe ser mayor que 0.");
		if (idEspacioFisico != null && idEspacioFisico.isEmpty())
			throw new IllegalArgumentException("El id del espacio físico no puede ser vacío.");

		Optional<Evento> evento2 = repositorioEvento.findById(idEvento);
		if (!evento2.isPresent())
			throw new EntityNotFoundException("Error al encontrar el evento con id " + idEvento + ".");

		Evento evento = evento2.get();
		if (descripcion != null)
			evento.setDescripcion(descripcion);
		if (fechaInicio != null)
			evento.setFechaInicio(fechaInicio);
		if (fechaFin != null)
			evento.setFechaFin(fechaFin);
		if (numPlazas != -1)
			evento.setPlazas(numPlazas);
		if (idEspacioFisico != null) {
			// evento.setEspacioFisico(repositorioEspacio.getById(idEspacioFisico));
		}

		repositorioEvento.save(evento);
	}

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

	@Override
	public String eventosDelMes(int mes, int año) {

		if (mes < 1 || mes > 12)
			throw new IllegalArgumentException("El mes debe estar comprendido entre 1 y 12.");
		if (año < 0)
			throw new IllegalArgumentException("El año no puede ser negativo.");

		// List<Evento> eventos = repositorioEvento.getEventosDelMes(mes, año);
		// String resumenEventos =
		// eventos.stream().map(Evento::toString).collect(Collectors.joining(""));
		// return resumenEventos;

		return "";
	}

}