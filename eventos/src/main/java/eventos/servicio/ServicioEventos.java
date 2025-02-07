package eventos.servicio;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import eventos.modelo.Evento;
import eventos.modelo.EventoCategoria;
import eventos.repositorio.EntidadNoEncontrada;
import eventos.repositorio.FactoriaRepositorios;
import eventos.repositorio.IRepositorioAdHocEvento;
import eventos.repositorio.RepositorioException;

public class ServicioEventos implements IServicioEventos {

	private IRepositorioAdHocEvento repositorioEvento;

	public ServicioEventos() {
		repositorioEvento = FactoriaRepositorios.getRepositorio(Evento.class);
	}

	@Override
	public String altaEvento(String nombre, String descripcion, String organizador, EventoCategoria categoria,
			LocalDateTime fechaInicio,
			LocalDateTime fechaFin, int numPlazas, String idEspacioFisico)
			throws RepositorioException, EntidadNoEncontrada {

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
		// EspacioFisico espacioFisico = repositorioEspacio.getById(idEspacioFisico);
		// if (espacioFisico.isCancelado())
		// throw new IllegalArgumentException("El espacio físico con id " +
		// idEspacioFisico + " está cancelado.");
		// if (numPlazas > espacioFisico.getCapacidad())
		// throw new IllegalArgumentException(
		// "El número de plazas supera la capacidad del espacio físico con id " +
		// idEspacioFisico + ".");
		//
		// LinkedList<EspacioFisico> espaciosFisicos = new LinkedList<EspacioFisico>(
		// repositorioEspacio.getEspaciosFisicoLibres(fechaInicio, fechaFin,
		// numPlazas));
		//
		// boolean isEspacioFisicoLibre = espaciosFisicos.stream()
		// .anyMatch(espacio -> espacio.getId().equals(idEspacioFisico));
		// if (!isEspacioFisicoLibre)
		// throw new IllegalArgumentException(
		// "El espacio fisico con id " + idEspacioFisico + " no está disponible en la
		// fecha.");
		//
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
			int numPlazas, String idEspacioFisico)
			throws RepositorioException, EntidadNoEncontrada {

		if (idEvento == null || idEvento.isEmpty())
			throw new IllegalArgumentException("El id del evento no puede ser nulo o vacío.");
		if (descripcion != null && descripcion.isEmpty())
			throw new IllegalArgumentException("La descripción del evento no puede ser vacía.");
		if (numPlazas == 0 && numPlazas < -1)
			throw new IllegalArgumentException("El número de plazas del evento debe ser mayor que 0.");
		if (idEspacioFisico != null && idEspacioFisico.isEmpty())
			throw new IllegalArgumentException("El id del espacio físico no puede ser vacío.");

		try {
			Evento evento = repositorioEvento.getById(idEvento);

			if (descripcion != null)
				evento.setDescripcion(descripcion);
			if (fechaInicio != null)
				evento.setFechaInicio(fechaInicio);
			if (fechaFin != null)
				evento.setFechaFin(fechaFin);
			if (numPlazas != -1)
				evento.setPlazas(numPlazas);
			if (idEspacioFisico != null)
				// evento.setEspacioFisico(repositorioEspacio.getById(idEspacioFisico));

				repositorioEvento.update(evento);
		} catch (RepositorioException e) {
			throw new RepositorioException("Error al modificar el evento con id " + idEvento + ".");
		} catch (EntidadNoEncontrada e) {
			throw new EntidadNoEncontrada("Error al encontrar el evento con id " + idEvento + ".");
		}
	}

	@Override
	public void cancelarEvento(String idEvento) throws RepositorioException, EntidadNoEncontrada {

		if (idEvento == null || idEvento.isEmpty())
			throw new IllegalArgumentException("El id del evento no puede ser nulo o vacio.");

		try {
			Evento evento = repositorioEvento.getById(idEvento);
			evento.setCancelado();
			repositorioEvento.update(evento);
		} catch (RepositorioException e) {
			throw new RepositorioException("Error al cancelar el evento con id " + idEvento + ".");
		} catch (EntidadNoEncontrada e) {
			throw new EntidadNoEncontrada("Error al encontrar el evento con id " + idEvento + ".");
		}
	}

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

}